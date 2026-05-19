class DynamicArray {

    private int[] array;
    private int nextFreeIndex;

    public DynamicArray(int capacity) {
        this.array = new int[capacity];
        this.nextFreeIndex = 0;
    }

    public int get(int i) {
        return this.array[i];
    }

    public void set(int i, int n) {
        this.array[i] = n;
    }

    public void pushback(int n) {
        if(this.nextFreeIndex > this.array.length -1){
            this.resize();
        }
        this.array[this.nextFreeIndex] = n;
        this.nextFreeIndex += 1;
    }

    public int popback() {
        return this.array[--nextFreeIndex];
    }

    private void resize() {
        int[] newArray = new int[this.array.length * 2];
        for(int i = 0; i < this.array.length; i++){
           newArray[i] = this.array[i];
        }
        this.array = newArray;
    }

    public int getSize() {
        return this.nextFreeIndex;
    }

    public int getCapacity() {
        return this.array.length;

    }
}
