package com.wsk.powers.base;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.wsk.actions.DarkTemplePowerAction;
import com.wsk.utils.CommonUtil;

/**
 * @author wsk1103
 * @date 2019/2/26
 * @desc 一句话说明
 */
public class DarkTemplePowerUpgraded extends AbstractPower {
    public static final String POWER_ID = "LagranYue:DarkTemplePowerUpgraded";
    public static final String NAME = "自我封印·暗黑神殿 +";
    public static String[] DESCRIPTIONS = {"每回合开始获得", "张0费的 卢恩符文+·守 或 卢恩符文+·造 。"};

    private static final String IMG = "powers/w24.png";
    private static PowerType POWER_TYPE = PowerType.BUFF;

    public DarkTemplePowerUpgraded(AbstractCreature owner, int amount) {
        this.ID = POWER_ID;
        this.DESCRIPTIONS = CardCrawlGame.languagePack.getPowerStrings(this.ID).DESCRIPTIONS;

        this.name = CardCrawlGame.languagePack.getPowerStrings(this.ID).NAME;
//        this.name = NAME;
        this.owner = owner;
        this.amount = amount;
        this.img = new Texture(CommonUtil.getResourcePath(IMG));
        updateDescription();//调用该方法（第36行）的文本更新函数,更新一次文本描叙，不可缺少。
        this.type = POWER_TYPE;
        updateDescription();
    }

    public void updateDescription() {
        this.description = (DESCRIPTIONS[0] + (this.amount) + DESCRIPTIONS[1]);
    }

    public void atStartOfTurn() {
        flash();
        DarkTemplePowerAction.action((AbstractPlayer) owner, amount, true);
//        for (AbstractMonster m : AbstractDungeon.getMonsters().monsters) {
//            if ((!m.isDead) && (!m.isDying)) {
//                AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(m, this.owner,
//                        new ImprintPower(m, this.owner, this.amount * 2), this.amount * 2, true, AbstractGameAction.AttackEffect.POISON));
//            }
//        }
    }
}
