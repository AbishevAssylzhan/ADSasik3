class Experiment {

    Sorter sorter = new Sorter();
    Searcher searcher = new Searcher();

    long measureSortTime(int[] arr, String type) {
        long start = System.nanoTime();

        if (type.equals("basic")) {
            sorter.basicSort(arr);
        } else {
            sorter.advancedSort(arr);
        }

        long end = System.nanoTime();
        return end - start;
    }

    long measureSearchTime(int[] arr, int target) {
        long start = System.nanoTime();

        searcher.search(arr, target);

        long end = System.nanoTime();
        return end - start;
    }

    void runAllExperiments() {
        int[] sizes = {10, 100, 1000};

        for (int size : sizes) {
            int[] arr1 = sorter.generateRandomArray(size);
            int[] arr2 = arr1.clone();

            long basicTime = measureSortTime(arr1, "basic");
            long advancedTime = measureSortTime(arr2, "advanced");

            int target = arr2[size / 2];
            long searchTime = measureSearchTime(arr2, target);

            System.out.println("Size: " + size);
            System.out.println("Bubble Sort time: " + basicTime + " ns");
            System.out.println("Merge Sort time: " + advancedTime + " ns");
            System.out.println("Binary Search time: " + searchTime + " ns");
            System.out.println();
        }
    }
}