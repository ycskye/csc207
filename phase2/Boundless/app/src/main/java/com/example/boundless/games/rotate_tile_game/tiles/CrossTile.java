package com.example.boundless.games.rotate_tile_game.tiles;

import android.graphics.BitmapFactory;

import com.example.boundless.Panel;
import com.example.boundless.R;

/**
 * A tile that looks like an +.
 */
class CrossTile extends Tile {

    CrossTile() {
        super(new int[]{1, 1, 1, 1}, BitmapFactory.decodeResource(Panel.getPanel().getResources(), R.drawable.cross_pipe));
    }
}
