package com.laioffer.twitch.favorite;


import com.laioffer.twitch.db.entity.ItemEntity;


public record FavoriteRequestBody(
        ItemEntity favorite
) {}
