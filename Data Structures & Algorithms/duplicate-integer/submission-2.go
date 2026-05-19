func hasDuplicate(nums []int) bool {
	var m map[int]bool
	m = make(map[int]bool)

	for _, num := range nums {
		b := m[num]

		if b {
			return true 
		}
		m[num] = true
	}

	return false
}

