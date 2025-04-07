/*
 * Copyright (c) 2024 - The MegaMek Team. All Rights Reserved.
 *
 * This file is part of MegaMek.
 *
 * MegaMek is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MegaMek is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MegaMek. If not, see <http://www.gnu.org/licenses/>.
 */
package megamek.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import megamek.common.icons.Camouflage;
import org.junit.jupiter.api.Test;

import megamek.client.ui.swing.util.PlayerColour;

import java.util.Collection;
import java.util.Vector;

class PlayerTest {

    @Test
    void testGetColorForPlayerDefault() {
        String playerName = "Test Player 1";
        Player player = new Player(0, playerName);
        assertEquals("<B><font color='8080b0'>" + playerName + "</font></B>", player.getColorForPlayer());
    }

    @Test
    void testGetColorForPlayerFuchsia() {
        String playerName = "Test Player 2";
        Player player = new Player(1, playerName);
        player.setColour(PlayerColour.FUCHSIA);
        assertEquals("<B><font color='f000f0'>" + playerName + "</font></B>", player.getColorForPlayer());
    }

    @Test
    void testGetCamouflageCategory(){
        String playerName = "Test Player 3";
        Player player = new Player(2, playerName);
        Camouflage camouflage = new Camouflage(Camouflage.COLOUR_CAMOUFLAGE, PlayerColour.BLUE.name());
        Camouflage camouflageTest = new Camouflage(Camouflage.COLOUR_CAMOUFLAGE, PlayerColour.RED.name());
        player.setCamouflage(camouflage);
        assertEquals(camouflage.getCategory(), player.getCamouflage().getCategory());
    }

    @Test
    void removePlayerArty(){
        String playerName = "Test Player 4";
        Player player = new Player(0, playerName);
        Vector<Coords> arty = new Vector<>();

        arty.add(new Coords(1,1));
        arty.add(new Coords(2,2));

        player.setArtyAutoHitHexes(arty);
        assertEquals(arty.size(), player.getArtyAutoHitHexes().size());

        player.removeArtyAutoHitHexes();
        assertEquals(arty.size(), player.getArtyAutoHitHexes().size());
    }

    @Test
    void testPlayerInformations(){
        String playerName = "Test Player 5";
        Player player = new Player(0, "test");
        player.setName(playerName);
        assertEquals(playerName, player.getName());

        String playerEmail = "test@gmail.com";
        player.setEmail(playerEmail);
        assertEquals(playerEmail, player.getEmail());
    }

    @Test
    void testPlayerTeam(){
        Player testPlayer = new Player(0, "test");
        Player testPlayer2 = new Player(1, "test");

        testPlayer.setTeam(Player.TEAM_NONE);
        testPlayer2.setTeam(Player.TEAM_NONE);

        assertEquals(testPlayer.getTeam(), testPlayer2.getTeam());
    }

    @Test
    void playerIsGameMaster(){
        Player testPlayer = new Player(0, "test");
        testPlayer.setGameMaster(true);

        assertTrue(testPlayer.getGameMaster());
    }

    @Test
    void playerConnectedAsBot(){
        Player testPlayer = new Player(0, "test");
        testPlayer.setBot(true);

        assertTrue(testPlayer.isBot());
    }

    @Test
    void playerMinefield(){
        Player testPlayer = new Player(0, "test");
        Minefield mf = Minefield.createMinefield(new Coords(1,1), testPlayer.getId(), Minefield.TYPE_ACTIVE,
              Minefield.MAX_DAMAGE);
        testPlayer.minefieldManager.addMinefield(mf);
        PlayerMinefieldManager mfManager = testPlayer.minefieldManager.copy();

        assertEquals(mfManager.containsMinefield(mf), testPlayer.minefieldManager.containsMinefield(mf));
    }
}
