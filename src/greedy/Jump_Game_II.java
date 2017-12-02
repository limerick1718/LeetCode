package greedy;

public class Jump_Game_II {

	public int jump(int[] nums) {
		if (nums.length == 1) return 0;
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + nums[i];
		}
		int step = 1;
		int left = 0;
		int max = nums[0];
		int localMax = nums[left + 1];
		int localPos = left + 1;
		while (max < nums.length - 1) {
			for (int i = left + 1; i <= max; i++) {
				if (nums[i] > localMax) {
					localMax = nums[i];
					localPos = i;
				}
			}
			left = localPos;
			max = localMax;
			step++;
		}
		return step;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {4,3,2,1,0,5};
		Jump_Game_II jump_Game_II = new Jump_Game_II();
		int jump = jump_Game_II.jump(nums);
		System.out.println(jump);
	}

}
