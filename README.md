# sorting-mini-project
As the name suggests, it's our mini-project for the sorting lab.

Author: Lucas Willett
Date: 4/04/2024

Received suggestions and edits from Alyssa Trapp on merge sort. Used framework on mergeSort, InsertionSort and QuickSort from Sam R and the 207 website. Started working on Quicksort (barely) in class with David Rhoades and Nye Tenerelli.

This program gives multiple different ways to sort an array in Java. InsertionSort does this by going down the end of the array and placing each item on the left where it should be sorted. MergeSort does this by recursivly calling itself and splitting in half, and once it has two halfs that are sorted, it merges the two together in a sorted order, and does that all the way until everything is sorted. QuickSort does this by taking the midpoint and partitioning it to the correct place, then recursivly calling itself on both sides of the partition. There are also multiple tests that will be used on each method of sorting.