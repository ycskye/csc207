package com.example.boundless.games.rotate_tile_game.tiles;

import android.graphics.BitmapFactory;

import com.example.boundless.Panel;
import com.example.boundless.R;

/**
 * A tile that looks like an I.
 */
class StraightTile extends Tile {
    StraightTile() {
        super(new int[]{1, 0, 1, 0});
        originalImage = BitmapFactory.decodeResource(Panel.getPanel().getResources(), R.drawable.straight_pipe);
        rotatedImage = originalImage;
    }
}
