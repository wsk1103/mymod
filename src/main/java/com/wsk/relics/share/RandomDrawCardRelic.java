package com.wsk.relics.share;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.wsk.utils.CommonUtil;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author wsk1103
 * @date 2019/3/17
 * @description 每次战斗开始，重新排序抽牌卡堆。目的是每次SL之后，让抽到的卡牌都不一样。
 */
public class RandomDrawCardRelic extends CustomRelic {

    public static final String ID = "LagranYue:RandomDrawCardRelic";
    public static final String IMG = "relics/w35.png";
    public static final String OUTLINE = "relics/w36.png";

    public RandomDrawCardRelic() {
        super(ID, new Texture(CommonUtil.getResourcePath(IMG)), new Texture(CommonUtil.getResourcePath(OUTLINE)), RelicTier.STARTER, LandingSound.FLAT);
    }

    @Override
    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }

    @Override
    public AbstractRelic makeCopy() {
        return new RandomDrawCardRelic();
    }

    /**
     * 乱序抽牌卡组
     */
    @Override
    public void atPreBattle() {
        flash();
        AbstractPlayer player = AbstractDungeon.player;
        if (null != player) {
            ArrayList<AbstractCard> cards = player.drawPile.group;
            System.out.println(cards);
            Collections.shuffle(player.drawPile.group);
            System.out.println(player.drawPile.group);
        }
    }
}
