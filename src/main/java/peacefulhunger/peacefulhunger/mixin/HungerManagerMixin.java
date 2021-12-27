package peacefulhunger.peacefulhunger.mixin;

import net.minecraft.entity.player.HungerManager;
import net.minecraft.world.Difficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(HungerManager.class)
public class HungerManagerMixin {
    @ModifyVariable(method = "update", at = @At("STORE"))
    private Difficulty replaceDifficulty(Difficulty difficulty) {
        if (difficulty == Difficulty.PEACEFUL) {
            return Difficulty.EASY;
        }
        return difficulty;
    }
}
