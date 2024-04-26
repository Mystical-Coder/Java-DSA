public class RemoveDuplicates {
    
    public static void removeDup(String str, int indx, StringBuilder newStr, boolean[] arr){
        if(indx == str.length()){
            System.out.println(newStr);
            return;
        }
        char ch = str.charAt(indx);
        if(arr[ch - 'a'] == true){
            removeDup(str, indx + 1, newStr, arr);
        }else{
            arr[ch-'a']= true;
            removeDup(str, indx+1, newStr.append(ch), arr);
        }
    }

    public static void main(String[] args) {
        removeDup("visssshhhhhuuuuu", 0, new StringBuilder(), new boolean[26]);
    }
}
