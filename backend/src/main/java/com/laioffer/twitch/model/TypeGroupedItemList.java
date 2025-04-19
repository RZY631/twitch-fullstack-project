package com.laioffer.twitch.model;

import com.laioffer.twitch.db.entity.ItemEntity;
import com.laioffer.twitch.external.model.Clip;
import com.laioffer.twitch.external.model.Stream;
import com.laioffer.twitch.external.model.Video;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于将不同类型的媒体项（直播、视频、剪辑）分组的记录类。
 * 每种类型的项都会被分别放入对应的列表中，便于展示和处理。
 */
public record TypeGroupedItemList(
        List<ItemEntity> streams, // 存储直播类型的 ItemEntity
        List<ItemEntity> videos,  // 存储视频类型的 ItemEntity
        List<ItemEntity> clips    // 存储剪辑类型的 ItemEntity
) {

    /**
     * 构造函数：接收一个混合的 ItemEntity 列表，根据类型将其分类为
     * streams、videos 和 clips 三个列表。
     *
     * @param items 包含所有类型 ItemEntity 的混合列表
     */
    public TypeGroupedItemList(List<ItemEntity> items) {
        this(
                filterForType(items, ItemType.STREAM),
                filterForType(items, ItemType.VIDEO),
                filterForType(items, ItemType.CLIP)
        );
    }

    /**
     * 构造函数：接收已按类型分开的原始对象（Stream、Video、Clip），
     * 并将它们封装成统一的 ItemEntity 类型。
     *
     * @param gameId 这些媒体项对应的游戏 ID（仅用于视频）
     * @param streams 直播对象列表
     * @param videos 视频对象列表
     * @param clips 剪辑对象列表
     */
    public TypeGroupedItemList(String gameId, List<Stream> streams, List<Video> videos, List<Clip> clips) {
        this(
                fromStreams(streams),
                fromVideos(gameId, videos),
                fromClips(clips)
        );
    }

    /**
     * 根据指定类型筛选出目标 ItemEntity。
     *
     * @param items 要筛选的混合 ItemEntity 列表
     * @param type 目标类型（STREAM、VIDEO 或 CLIP）
     * @return 所有符合指定类型的 ItemEntity 列表
     */
    private static List<ItemEntity> filterForType(List<ItemEntity> items, ItemType type) {
        List<ItemEntity> filtered = new ArrayList<>();
        for (ItemEntity item : items) {
            if (item.type() == type) {
                filtered.add(item);
            }
        }
        return filtered;
    }

    /**
     * 将 Stream 对象转换为对应的 ItemEntity 列表。
     *
     * @param streams 直播对象列表
     * @return 封装后的 ItemEntity 列表
     */
    private static List<ItemEntity> fromStreams(List<Stream> streams) {
        List<ItemEntity> items = new ArrayList<>();
        for (Stream stream : streams) {
            items.add(new ItemEntity(stream));
        }
        return items;
    }

    /**
     * 将 Video 对象转换为对应的 ItemEntity 列表，并附加 gameId。
     *
     * @param gameId 游戏 ID
     * @param videos 视频对象列表
     * @return 封装后的 ItemEntity 列表
     */
    private static List<ItemEntity> fromVideos(String gameId, List<Video> videos) {
        List<ItemEntity> items = new ArrayList<>();
        for (Video video : videos) {
            items.add(new ItemEntity(gameId, video));
        }
        return items;
    }

    /**
     * 将 Clip 对象转换为对应的 ItemEntity 列表。
     *
     * @param clips 剪辑对象列表
     * @return 封装后的 ItemEntity 列表
     */
    private static List<ItemEntity> fromClips(List<Clip> clips) {
        List<ItemEntity> items = new ArrayList<>();
        for (Clip clip : clips) {
            items.add(new ItemEntity(clip));
        }
        return items;
    }
}
