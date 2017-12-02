package greedy;

public class Jump_Game {
	
	public boolean canJump(int[] nums) {
		int length = nums.length;
		int max = 0;
		for (int i = 0; i < length && i <= max; i ++) {
			if (nums[i] + i > max) {
				max = nums[i] + i;
			}
			if (max >= length - 1) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {0};
		Jump_Game jump_Game = new Jump_Game();
		boolean canJump = jump_Game.canJump(nums);
		System.out.println(canJump);
	}

}
