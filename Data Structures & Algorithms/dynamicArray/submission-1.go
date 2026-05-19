
type DynamicArray struct {
	capacity int
	size     int
	arr      []int
}

func NewDynamicArray(capacity int) *DynamicArray {
	return &DynamicArray{
		capacity: capacity,
		arr:      make([]int, capacity),
	}

}

func (da *DynamicArray) Get(i int) int {
	return da.arr[i]
}

func (da *DynamicArray) Set(i int, n int) {
	if da.capacity-1 < i {
		da.resize()
	}

	if da.size < i + 1 {
		da.size = i + 1
	}

	da.arr[i] = n
}

func (da *DynamicArray) Pushback(n int) {
	da.Set(da.size, n)
}

func (da *DynamicArray) Popback() int {
	lastElement := da.arr[da.size -1]
	for i := range da.arr {
		if i == da.size -1 {
			da.arr[i] = 0
			da.size -= 1
			break
		}

	}

	return lastElement
}

func (da *DynamicArray) resize() {
	da.capacity = da.capacity * 2
	newArr := make([]int, da.capacity)

	copy(newArr, da.arr)

	da.arr = newArr
}

func (da *DynamicArray) GetSize() int {
	return da.size
}

func (da *DynamicArray) GetCapacity() int {
	return da.capacity
}
