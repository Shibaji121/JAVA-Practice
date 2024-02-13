package DSAPractice;

import com.sun.deploy.util.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Solution {

    public static Map<String, Integer> sortHashMapByValue(HashMap<String, Integer> map) {
        // Convert HashMap to a list of Map.Entry
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        // Sort the list by values using a custom comparator
        list.sort(Map.Entry.comparingByValue());

        // Preserve the insertion order in LinkedHashMap
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
    public static String reverseString(String s) {
        //StringBuilder stringBuilder = new StringBuilder(s);
        //return stringBuilder.reverse().toString();
        char []reverse = s.toCharArray();
        int i = 0, j = s.length()-1;
        while(i < j) {
            reverse[i] = s.charAt(j);
            reverse[j] = s.charAt(i);
            i++;
            j--;
        }
        return String.valueOf(reverse);
    }
    public static boolean anagrams(String s1, String s2) {
        char []schar1 = s1.toCharArray();
        char []schar2 = s2.toCharArray();
        Arrays.sort(schar1);
        Arrays.sort(schar2);
        return Arrays.equals(schar1, schar2);
    }
    public static int secondLargest(int []arr) {
        int max = -1, secondMax = -1;
        for(int i : arr) {
            if(i > max) {
                secondMax = max;
                max = i;
            } else if (i < max && i > secondMax) {
                secondMax = i;
            }
        }
        return secondMax;
    }
    public static boolean isPrime(int n) {
        for(int i = 2; i<=Math.sqrt(n); i++){
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void fibonacciSeriesUptoAGivenRange(int n) {
        int first = 0, second = 1, next;
        for(int i = 0; i<n; i++) {
            System.out.print(first + " ");
            next = first + second;
            first = second;
            second = next;
        }
        System.out.println();
    }
    public static int reverseNumber(int n) {
        int rev = 0;
        while(n > 0) {
            int rem = n % 10;
            rev = rev * 10 + rem;
            n = n / 10;
        }
        return rev;
    }
    public static String reverseEachWord(String s) {
        String []strChar = s.split(" ");
        System.out.println("No of Words :" + strChar.length);
        StringBuilder answer = new StringBuilder();
        for(String str : strChar) {
            StringBuilder temp = new StringBuilder(str);
            answer.append(temp.reverse()).append(" ");
        }
        return answer.toString();
    }
    public static void findDuplicateCharsInString(String s) {
        char []charArr = s.toCharArray();
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char ch : charArr) {
            freqMap.put(ch, (freqMap.getOrDefault(ch, 0) + 1));
        }
        for(char ch : freqMap.keySet()){
            System.out.print(ch +":" + freqMap.get(ch) + " ");
        }
        System.out.println();
    }
    public static String modifyAsa2b2c2(String s) {
        StringBuilder ans = new StringBuilder();
        int count = 1;
        for(int i = 0; i<s.length(); i++) {
            if(i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                count++;
            } else {
                if(count == 1) {
                    ans.append(s.charAt(i));
                }else {
                    ans.append(s.charAt(i)).append(count);
                }
                count = 1;
            }
        }
        return ans.toString();
    }
    public static String modifyASaabbbccf(String s) {
        int len = s.length();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < len; ) {
            char ch = s.charAt(i);
            if (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                int freq = Character.getNumericValue(s.charAt(i + 1));
                for (int j = 0; j < freq; j++) {
                    output.append(ch);
                }
                i += 2;
            } else {
                output.append(ch);
                i++;
            }
        }
        return output.toString();
    }
    public static void bubbleSort(int[] arr){
        int i, j, temp, n = arr.length;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
        for(int num: arr){
            System.out.print(num + " ");
        }
    }
    public static int thirdHighestWithoutLoop(int []arr) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Set<Integer> set = new HashSet<>(list);
        List<Integer> sortedList = new ArrayList<>(set);
        sortedList.sort(Collections.reverseOrder());
        return sortedList.get(2);
    }
    public static void sort01(int []arr) {
        int length = arr.length;
        int start = 0, end = length-1;
        while (start < end) {
            if(arr[start] == 0) {
                start++;
            } else {
                if(arr[end] == 1) {
                    end--;
                } else {
                    int temp = arr[start];
                    arr[start] = arr[end];
                    arr[end] = temp;
                    start++;
                    end--;
                }
            }
        }
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
    public static void sort012(int []arr) {
        int length = arr.length;
        int start=0, mid=0, end=length-1;
        while(mid <= end) {
            if(arr[mid] == 0) {
                int temp = arr[start];
                arr[start] = arr[mid];
                arr[mid] = temp;
                start++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[end];
                arr[end] = arr[mid];
                arr[mid] = temp;
                end--;
            }
        }
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
    public static void patternMatcher(String input) {
        String regex = "";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if(matcher.matches()) {
            System.out.println("pattern Matched");
        }
    }

    public static void printAllPermutations(String s, String ans) {
         /*Consider calling printAllPermutations("abc", ""):

Initial Call: printAllPermutations("abc", "")

s is "abc" and ans is "".
First Level of Recursion:

For i = 0, ch = 'a', remaining string rem = "bc"
Call printAllPermutations("bc", "a")
For i = 1, ch = 'b', remaining string rem = "ac"
Call printAllPermutations("ac", "b")
For i = 2, ch = 'c', remaining string rem = "ab"
Call printAllPermutations("ab", "c")
Let's expand one of these calls to see how it produces permutations:

Expanding printAllPermutations("bc", "a")
For i = 0, ch = 'b', remaining string rem = "c"
Call printAllPermutations("c", "ab")
For i = 1, ch = 'c', remaining string rem = "b"
Call printAllPermutations("b", "ac")
Expanding printAllPermutations("c", "ab")
s = "c", so we make calls with each character:
For i = 0, ch = 'c', remaining string rem = ""
Call printAllPermutations("", "abc")
Here, s.length() == 0, so it prints "abc ".*/
        if(s.length() == 0) {
            System.out.print(ans + " ");
        }
        for(int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);
            String rem = s.substring(0,i) + s.substring(i+1);
            printAllPermutations(rem, ans + ch);
        }

    }
    public static void main(String[] args) {
        System.out.println(Solution.reverseString("Abcdef"));
        System.out.println(Solution.anagrams("Abc", "cbAd"));
        System.out.println(Solution.secondLargest(new int[]{1,2,3,3,5}));
        System.out.println(Solution.isPrime(9));
        Solution.fibonacciSeriesUptoAGivenRange(9);
        System.out.println(Solution.reverseNumber(1234567));
        System.out.println(Solution.reverseEachWord("Java is a good Programming Language"));
        Solution.findDuplicateCharsInString("aaabbccc");
        System.out.println("Java is a good Programming Language".replace(" ", ""));
        System.out.println(Solution.modifyAsa2b2c2("aaabbcccddefg"));
        System.out.println(Solution.modifyASaabbbccf("a2b3c4d2"));
        Solution.bubbleSort(new int[]{5, 2, 4, 3});
        System.out.println();
        System.out.println(Solution.thirdHighestWithoutLoop(new int[]{1,2,3,3,4,4,5}));
        Solution.sort01(new int[]{0,0,1,0,1,0,1});System.out.println();
        Solution.sort012(new int[]{0,1,0,1,2,0,2,1,0,1});System.out.println();
        Solution.printAllPermutations("ABC", "");

    }
}
