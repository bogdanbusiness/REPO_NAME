package gameobjects.cards.special_cards;

import gameobjects.cards.GenericCard;
import fileio.CardInput;
import utils.GameConstants;

import java.util.ArrayList;

public class TheCursedOne extends GenericCard {
    public TheCursedOne(final CardInput card) {
        super(card);
        super.setTank(false);
    }

    public TheCursedOne(final GenericCard card) {
        super(card);
        super.setTank(false);
    }

    @Override
    public final int getRowPlacement(final int playerIndex) {
        return playerIndex == 1 ? GameConstants.PLAYER1_BACK_ROW : GameConstants.PLAYER2_BACK_ROW;
    }

    @Override
    public final GenericCard useAbility(final ArrayList<GenericCard> cards) {
        if (cards.isEmpty()) {
            return null;
        }

        GenericCard enemy = cards.get(0);
        int enemyHP = enemy.getHealth();
        enemy.setHealth(enemy.getAttackDamage());
        enemy.setAttackDamage(enemyHP);
        super.setHasAttacked(true);

        return null;
    }
}

