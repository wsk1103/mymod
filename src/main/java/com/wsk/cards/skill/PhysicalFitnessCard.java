package com.wsk.cards.skill;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.wsk.cards.AbstractArmsCard;
import com.wsk.patches.AbstractCardEnum;
import com.wsk.utils.CommonUtil;

/**
 * @author wsk1103
 * @date 2019/2/26
 * @desc 一句话说明
 */
public class PhysicalFitnessCard extends CustomCard {
    public static final String ID = "MyMod:PhysicalFitnessCard";//卡牌在游戏中的id
    private static final String NAME/* = "来自WSK的庇护"*/;//卡牌显示的名称

    private static final String DESCRIPTION /*= "获得 2 点 力量"*/;//卡牌下方的描叙内容。

    private static final String UPGRADED_DESCRIPTION /*= "获得 2 点 力量"*/;//卡牌下方的描叙内容。

    private static final CardStrings cardStrings;

    private static final String IMG = "cards/slimepunch.png";//卡牌牌面的图片路径。
    //例：img/cards/claw/attack/BloodSuckingClaw_Orange.png  详细情况请根据自己项目的路径布置进行填写。

    private static final int COST = 2;//卡牌的费用。

    public PhysicalFitnessCard() {
        super(ID, NAME, CommonUtil.getResourcePath(IMG), COST, DESCRIPTION,
                CardType.SKILL,
                AbstractCardEnum.MyModCard,
                CardRarity.UNCOMMON, CardTarget.SELF);
        this.baseBlock = 7;
        this.exhaust = true;
        this.magicNumber = this.baseMagicNumber = 1;
    }

    //用于显示在卡牌一览里。同时也是诸多卡牌复制效果所需要调用的基本方法，用来获得一张该卡的原始模板修改后加入手牌/抽牌堆/弃牌堆/牌组。
    public AbstractCard makeCopy() {
        return new PhysicalFitnessCard();
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();//升级名称。必带。
            this.rawDescription = UPGRADED_DESCRIPTION;
            this.initializeDescription();
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster abstractMonster) {
        AbstractDungeon.actionManager.addToBottom(new GainBlockAction(p, p, this.block));
        AbstractCard c;
        for (AbstractCard card : p.drawPile.group) {
            if (card instanceof AbstractArmsCard) {
                c = card.makeCopy();
                //设置保留
                c.retain = true;
                if (upgraded) {
                    c.modifyCostForTurn(this.magicNumber * -3);
                }
                AbstractDungeon.actionManager.addToBottom(new MakeTempCardInHandAction(c, true));
                break;
            }
        }
    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
        UPGRADED_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    }

}