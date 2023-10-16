package MauHanhVi.StrategyPattern;

public class testStrategyPattern {
    public static void main(String[] args) {
        SortContext context = new SortContext(new SelectionSort());
        context.printSort();

        context.setSort(new MergeSort());
        context.printSort();

        context.setSort(new QuickSort());
        context.printSort();
    }
}
