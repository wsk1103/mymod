package com.wsk.cards.attack;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.wsk.patches.AbstractCardEnum;
import com.wsk.utils.ArmsUtil;
import com.wsk.utils.CommonUtil;

/**
 * @author wsk1103
 * @date 2019/3/2
 * @desc 一句话说明
 */
public class AttackLuEnCard extends CustomCard {
    public static final String ID = "LagranYue:AttackLuEnCard";
    private static final String NAME /*= "来自WSK的攻击"*/;//卡牌显示的名称

    private static final String DESCRIPTION /*= "造成 !D! 点伤害。"*/;//卡牌下方的描叙内容。
    private static final CardStrings cardStrings;
    private static final String IMG = "cards/AttackLuEnCard.png";//卡牌牌面的图片路径。
    //例：img/cards/claw/attack/BloodSuckingClaw_Orange.png  详细情况请根据自己项目的路径布置进行填写。

    private static final int COST = 0;

    private static final int wskAttack = 5;

    public AttackLuEnCard() {
        super(ID, NAME, CommonUtil.getResourcePath(IMG), COST, DESCRIPTION,
                CardType.ATTACK, AbstractCardEnum.LagranYue,
                CardRarity.SPECIAL, CardTarget.ALL_ENEMY);
        this.magicNumber = this.baseMagicNumber = 1;
        this.baseDamage = wskAttack;//基础伤害值，除升级以外无任何其他加成. this.damage为有力量、钢笔尖等加成的伤害值.
        this.isEthereal = true;//虚无属性，false不虚无，true虚无。可在该类里调用改变。不虚无就可以赋值为false或者删掉这一行
        this.exhaust = true;//消耗属性，false不消耗，true消耗。可在该类里调用改变。不消耗就可以赋值为false或者删掉这一行
        this.isInnate = false;//固有属性，false不固有，true固有。可在该类里调用改变。不固有就可以赋值为false或者删掉这一行
    }

    public AbstractCard makeCopy() {
        return new AttackLuEnCard();
    }//用于显示在卡牌一览里。同时也是诸多卡牌复制效果所需要调用的基本方法，用来获得一张该卡的原始模板修改后加入手牌/抽牌堆/弃牌堆/牌组。

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();//升级名称。必带。
            this.upgradeMagicNumber(1);
        }
    }//注：该部分为升级的效果部分，此处展示的代码为只能升级一次的代码，如需无限升级，卡牌代码有些许不同但不便于例出，请自行查看灼热攻击源码。

    //以上为卡牌的必备内容，不可缺少。
    public void use(AbstractPlayer p, AbstractMonster m) {//局部变量：p-玩家，m敌人。
        //注：以下注释里：执行者 指动作效果生效的目标。给予者 指产生动作效果的来源。
        int num = ArmsUtil.currentAllArmsNum() * this.magicNumber;
//        AbstractDungeon.actionManager.addToBottom(new DamageAction(m,
//                new DamageInfo(p, num, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
        AbstractDungeon.actionManager.addToBottom(new DamageAllEnemiesAction(null,
                DamageInfo.createDamageMatrix(num, true),
                DamageInfo.DamageType.THORNS, AbstractGameAction.AttackEffect.FIRE));
    }//注：卡牌效果的diy区。

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
//        UPGRADED_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    }

}
