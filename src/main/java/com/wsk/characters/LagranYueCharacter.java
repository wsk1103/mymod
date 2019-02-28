package com.wsk.characters;

import basemod.abstracts.CustomPlayer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.ScreenShake;
import com.megacrit.cardcrawl.screens.CharSelectInfo;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import com.wsk.cards.attack.*;
import com.wsk.cards.power.*;
import com.wsk.cards.skill.*;
import com.wsk.patches.AbstractCardEnum;
import com.wsk.patches.CharacterEnum;
import com.wsk.powers.DoubleArmsPower;
import com.wsk.relics.EnkiduRelics;
import com.wsk.utils.CommonUtil;

import java.util.ArrayList;

/**
 * @author wsk1103
 * @date 2019/2/14
 * @desc 一句话说明
 */
public class LagranYueCharacter extends CustomPlayer {
    private static final int ENERGY_PER_TURN = 3;//角色的初始能量值。
    private static final String[] orbTextures = {"LagranYue/char/orb/layer1.png",
            "LagranYue/char/orb/layer2.png",
            "LagranYue/char/orb/layer3.png",
            "LagranYue/char/orb/layer4.png",
            "LagranYue/char/orb/layer5.png",
            "LagranYue/char/orb/layer6.png",
            "LagranYue/char/orb/layer1d.png",
            "LagranYue/char/orb/layer2d.png",
            "LagranYue/char/orb/layer3d.png",
            "LagranYue/char/orb/layer4d.png",
            "LagranYue/char/orb/layer5d.png"};
    //战斗界面左下角的能量图标组，详参压缩包内img文件夹内容。
    //也是战斗界面左下角的能量图标的一部分，详参压缩包内img文件夹内容。
    private static final String orbVfx = "LagranYue/char/orb/vfx.png";

    private static Color cardRenderColor = new Color(0.0F, 0.1F, 0.0F, 1.0F);

    public LagranYueCharacter(String name, AbstractPlayer.PlayerClass setClass) {
        super(name, setClass, orbTextures, orbVfx,
                CommonUtil.getResourcePath("LagranYue.g3dj")/* 人物角色立绘动画文件路径*/,
                "LagranYue|idle"/*人物角色立绘图片名*/);
        //人物角色立绘动画文件路径  格式："img/char/CharacterName/CharacterName_md.g3dj"。g3dj文件决定人物动画。
        //人物角色立绘图片名  格式："CharacterName_md|idle"。该文件为png格式，和CharacterName_md.g3dj放在同一目录下。
        //g3dj文件见压缩包内img文件夹内内容。

//        this.dialogX = this.drawX + 0.0f * Settings.scale;
//        this.dialogY = this.drawY + 240.0f * Settings.scale;
        //决定初始的XY坐标，游戏内“能量不足”等文本提示位置基于该坐标。

//        this.initializeClass("人物角色立绘图片路径", "篝火内休息前图片路径", "篝火内休息后图片路径", "死亡结算界面图片路径", getLoadout(), 20.0F, -10.0F, 220.0F, 290.0F, new EnergyManager(ENERGY_PER_TURN));
        this.initializeClass((String) null,
                "LagranYue/char/shoulder2.png",
                "LagranYue/char/shoulder.png",
                "LagranYue/char/corpse.png",
                this.getLoadout(),
                0.0F, 0.0F, 300.0F, 180.0F,
                new EnergyManager(ENERGY_PER_TURN));
//        this.reloadAnimation();
        this.dialogY += -100 * Settings.scale;
//        initializeSlotPositions();
    }

    //添加初始牌组
    public ArrayList<String> getStartingDeck() {
        ArrayList<String> retVal = new ArrayList<>();
        retVal.add(BaseAttackCard.ID);
        retVal.add(BaseAttackCard.ID);
        retVal.add(BaseAttackCard.ID);
        retVal.add(BaseAttackCard.ID);

        retVal.add(BaseDefendCard.ID);
        retVal.add(BaseDefendCard.ID);
        retVal.add(BaseDefendCard.ID);
        retVal.add(BaseDefendCard.ID);

        retVal.add(BasePowerCard.ID);
        retVal.add(SkillWoodSpearCard.ID);

//        retVal.add(SkillBlazingSevenRingsCard.ID);
//        retVal.add(SkillBlazingSevenRingsCard.ID);
//        retVal.add(SkillKadeboSwordCard.ID);
//        retVal.add(SkillKadeboSwordCard.ID);
//        retVal.add(SkillKadeboSwordCard.ID);
//        retVal.add(AttackSummerCard.ID);
//        retVal.add(AttackDevilCard.ID);
//        retVal.add(AttackFutureCard.ID);
//        retVal.add(AttackGoldCard.ID);
//        retVal.add(AttackKillerCard.ID);
//        retVal.add(AttackKingCard.ID);
//        retVal.add(AttackLakeCard.ID);
//        retVal.add(AttackRavagedCard.ID);
//        retVal.add(PowerDoubleArmsCard.ID);
//        retVal.add(SapphirePrayerCard.ID);
//        retVal.add(AttackEmeraldCard.ID);
//        retVal.add(AttackFireCard.ID);
//        retVal.add(AttackIceCard.ID);
//        retVal.add(AttackPurpleCard.ID);
//        retVal.add(AttackRubyCard.ID);
//        retVal.add(AttackTopazCard.ID);


//        retVal.add(AttackBetterCard.ID);
//        retVal.add(AttackEmeraldCard.ID);
//        retVal.add(AttackFireCard.ID);
//        retVal.add(AttackIceCard.ID);
//        retVal.add(AttackPurpleCard.ID);
//        retVal.add(AttackRubyCard.ID);
//        retVal.add(AttackSapphireCard.ID);
//        retVal.add(AttackSummerCard.ID);
//        retVal.add(AttackTopazCard.ID);
//        retVal.add(BaseAttackCard.ID);
//
//
//        retVal.add(BasePowerCard.ID);
//        retVal.add(PowerBloodyTempleCard.ID);
//        retVal.add(PowerDarkTempleCard.ID);
//        retVal.add(PowerDoubleArmsCard.ID);
//        retVal.add(PowerDreamCard.ID);
//        retVal.add(PowerGoldStartCard.ID);
//        retVal.add(PowerKingTreasureCard.ID);
//        retVal.add(PowerRemoveArmorCard.ID);
//        retVal.add(PowerTwelveTrialsCard.ID);
//        retVal.add(PowerWindKingEnchantmentCard.ID);
//
//        retVal.add(BaseDefendCard.ID);
//        retVal.add(BraveTemperamentCard.ID);
//        retVal.add(DefendBetterCard.ID);
//        retVal.add(EatTigerCard.ID);
//        retVal.add(EmeraldRemorseCard.ID);
//        retVal.add(FantasyCard.ID);
//        retVal.add(MagicSkyrocketCard.ID);
//        retVal.add(MultipleThornsCard.ID);
//        retVal.add(PhysicalFitnessCard.ID);
//        retVal.add(PrematureBurialCard.ID);
//        retVal.add(ProjectionCard.ID);
//        retVal.add(PurpleNightmareCard.ID);
//        retVal.add(RoseCard.ID);
//        retVal.add(RubyDefendCard.ID);
//        retVal.add(SapphirePrayerCard.ID);
//        retVal.add(SkillBlazingSevenRingsCard.ID);
//        retVal.add(SkillBrokenShieldCard.ID);
//        retVal.add(SkillBrokenSwordCard.ID);
//        retVal.add(SkillChiharaHoundCard.ID);
//        retVal.add(SkillDeathBolgCard.ID);
//        retVal.add(SkillExplosiveArmorCard.ID);
//        retVal.add(SkillGaeBolgCard.ID);
//        retVal.add(SkillGanJiangMoYeSwordCard.ID);
//        retVal.add(SkillIncompleteArchCard.ID);
//        retVal.add(SkillKadeboSwordCard.ID);
//        retVal.add(SkillVictorySwordCard.ID);
//        retVal.add(SkillWoodSpearCard.ID);
        return retVal;
    }

    //添加初始遗物
    public ArrayList<String> getStartingRelics() {
        ArrayList<String> retVal = new ArrayList<>();
        retVal.add(EnkiduRelics.ID);
        UnlockTracker.markRelicAsSeen(EnkiduRelics.ID);
        return retVal;
    }

    //在角色选择界面的一些描叙内容。
    public CharSelectInfo getLoadout() {
        final int currentHp = 75;//初始拥有血量
        final int maxHp = currentHp;//初始最大血量
        final int maxOrbs = 0;//球球数
        final int gold = 99;//初始金币数量
        final int cardDraw = 5;//每回合抽牌数量
        return new CharSelectInfo("拉格朗·月", "致力于成为武器大师的拉格朗·月，将要踏平这座高楼！" +
                "据说仰慕约瑟夫·拉格朗日（Joseph-Louis Lagrange，1736~1813）\n " +
                "将使用拉格朗日中值定理选择平衡。-----Make In China",
                currentHp, maxHp, maxOrbs, gold, cardDraw,
                this, getStartingRelics(), getStartingDeck(), false);
    }

    @Override
    public String getTitle(AbstractPlayer.PlayerClass playerClass) {
        return "拉格朗·月";
    }

    @Override
    public AbstractCard.CardColor getCardColor() {
        return AbstractCardEnum.LagranYue;
    }

    @Override
    public Color getCardRenderColor() {
        return cardRenderColor;
    }

    @Override
    public AbstractCard getStartCardForEvent() {
        return new BaseAttackCard();
    }

    @Override
    public Color getCardTrailColor() {
        return cardRenderColor.cpy();
    }

    @Override
    public int getAscensionMaxHPLoss() {
        return 10;
    }

    @Override
    public BitmapFont getEnergyNumFont() {
        return FontHelper.energyNumFontGreen;
    }

    @Override
    public void doCharSelectScreenSelectEffect() {
        CardCrawlGame.sound.playA("LagranYue", MathUtils.random(-0.2F, 0.2F));
        CardCrawlGame.screenShake.shake(ScreenShake.ShakeIntensity.MED, ScreenShake.ShakeDur.SHORT, true);
    }

    @Override
    public String getCustomModeCharacterButtonSoundKey() {
        return "LagranYue";
    }

    @Override
    public String getLocalizedCharacterName() {
        return "拉格朗·月";
    }

    @Override
    public AbstractPlayer newInstance() {
        return new LagranYueCharacter("拉格朗·月", CharacterEnum.LagranYueCharacter);
    }

    @Override
    public String getSpireHeartText() {
        return "getSpireHeartText";
    }

    @Override
    public Color getSlashAttackColor() {
        return Color.GREEN;
    }

    @Override
    public AbstractGameAction.AttackEffect[] getSpireHeartSlashEffect() {
        return new AbstractGameAction.AttackEffect[]{AbstractGameAction.AttackEffect.BLUNT_HEAVY,
                AbstractGameAction.AttackEffect.SMASH,
                AbstractGameAction.AttackEffect.BLUNT_HEAVY,
                AbstractGameAction.AttackEffect.BLUNT_HEAVY,
                AbstractGameAction.AttackEffect.SMASH,
                AbstractGameAction.AttackEffect.BLUNT_HEAVY};
    }

    @Override
    public String getVampireText() {
        return com.megacrit.cardcrawl.events.city.Vampires.DESCRIPTIONS[5];
    }
}