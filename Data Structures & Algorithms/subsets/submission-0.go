func subsets(nums []int) [][]int {
	res := [][]int{}

	return dfs(res, nums, []int{})
}

func dfs(res [][]int, nums []int, curr []int) [][]int {
	if len(nums) <= 0 {
		res = append(res, curr)
		return res
	}
	num := nums[0]
	newCurr := make([]int, len(curr))
	copy(newCurr, curr)
	newCurr = append(newCurr, num)

	res = dfs(res, nums[1:], newCurr)
	res = dfs(res, nums[1:], curr)
	return res
}
