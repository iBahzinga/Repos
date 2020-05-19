/**
 * Sortierverfahren um ein Array bestehend aus Zahlen zu sortieren.
 *
 * @author Santa Rudevica
 * @author Daniel Dichte
 * @author Pascal Kießler
 *
 * @version 1.0
 * @version 19.05.2020
 */
public class TimSort {
    static int RUN = 32;

    /**
     * Sortiert nach der Insertion Sort Variante.
     *
     * @param arr Array bestehend aus Integern
     * @param left Linke Seite des zu sortierenden Arrays
     * @param right Rechte Seite des zu sortierenden Arrays
     */
    public void insertionSort(Integer[] arr, int left, int right)
    {
        for (int i = left + 1; i <= right; i++)
        {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp)
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }


    /**
     * Aufeinanderbrechen in kleinere Teilarrays.
     * Sortieren der Teilarrays.
     * Mergen der Teilarrays in ein großes sortiertes Array
     *
     * @param arr Array bestehend aus Integern
     * @param l Linke Seite des Arrays
     * @param m Mitte des Arrays
     * @param r Rechte seite des Arrays
     */
    public void merge(Integer[] arr, int l, int m, int r)
    {
        //Default Array wird in 2 hälften(links und rechts) geteilt
        int len1 = m - l + 1, len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];
        for (int x = 0; x < len1; x++)
        {
            left[x] = arr[l + x];
        }
        for (int x = 0; x < len2; x++)
        {
            right[x] = arr[m + 1 + x];
        }

        int i = 0;
        int j = 0;
        int k = l;

        // Nach vergleichen, fügen wir die beiden Arrays wieder zusammen in ein größeres Subarray
        while (i < len1 && j < len2)
        {
            if (left[i] <= right[j])
            {
                arr[k] = left[i];
                i++;
            }
            else
            {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Die übergebliebenden Elemente vom linken Subarray (left)
        while (i < len1)
        {
            arr[k] = left[i];
            k++;
            i++;
        }

        // Die übergebliebenden Elemente vom rechten Subarray (right)
        while (j < len2)
        {
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    /**
     * Ein sortierverfahren wo das Anfangsarray in mehrere Subarrays unterteilt wird.
     * Die Subarray werden immer wieder sortiert und im Anschluss gemerged
     *
     * @param arr Array bestehend aus Integern
     * @param n Anzahl Elemente in Array
     */
    public void timSort(Integer[] arr, int n)
    {

        // Sortieren von den Subarrays
        for (int i = 0; i < n; i += RUN)
        {
            insertionSort(arr, i, Math.min((i + 31), (n - 1)));
        }
        //Startet das zusammenfügen der sortierten Subarrays.
        // Wir fügen erst 32er größen zusammen, dann 64er, 128er usw...
        for (int size = RUN; size < n; size = 2 * size)
        {
            //Zusammenfügen von arr[left..left+size-1] und arr[left+size, left+2*size-1]
            // Nach dem Zusammenfügen erhöhen wir links um die doppelte größe
            for (int left = 0; left < n; left += 2 * size)
            {
                // Finden des linken Endpunktes des Subarrays
                //mid + 1 ist der Startpunkt des rechten Subarrays
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));

                // merge sub array arr[left.....mid] &
                // arr[mid+1....right]
                if (mid >= n-1) { } else {
                    merge(arr, left, mid, right);
                }
            }
        }
    }
}