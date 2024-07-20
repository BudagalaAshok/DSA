package com.dsalgo.binarySearch;

public class BookAllocationUsingBS {

    //Allocates books to the students such that we need to find the min allocation of books out of max (possible solutions)
    //Each student should allocate at least one book
    // All books should be allocated in contiguous order
    public static int findMaxAllocationNumber(int[] books, int students) {

        //Min books we can allocate for an student is the min books book
        //Max is allocated is the sum of the all books, so calculate min and max so it became low and high

        int low = -1;
        int high = 0;

        if (students > books.length) {
            return -1;
        }
        for (int eachBook : books) {
            if (low < eachBook) {
                low = eachBook;
            }
            high += eachBook;
        }
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            //Need to find a valid possible assignemnt with this mid value to all the students
            if (isValidAssignment(books, mid, students)) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }

        }
        return ans;
    }

    private static boolean isValidAssignment(int[] pages, int mid, int students) {

        int pc = 0;
        int student = 1;
        for (int i = 0; i < pages.length; i++) {

            //First check if arr element is greater than mid then directly return false because it is not an possible solution
            if (pages[i] > mid) {
                return false;
            }
            if (pc + pages[i] <= mid) {
                pc += pages[i];
            } else {
                //allocates pages to next student
                student++;
                //Checking if student count is more than the allocated student, this will come if pages are left but students are not there
                // It means it is not an possible solution
                if (student > students) {
                    return false;
                }
                //Assign pages to the allocated student
                pc = pages[i];
            }


        }
        //if all elements are iterated in the array then it is an possible solution
        return true;
    }

    public static void main(String[] args) {
        // System.out.println(findMaxAllocationNumber(new int[]{25, 45, 50, 67}, 3));
        System.out.println(findMaxAllocationNumber(new int[]{12, 34, 67, 90}, 2));
    }

}
