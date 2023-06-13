public class Permutation {
    static void perm(String res, String str) {
        if (str.isEmpty()) {
            System.out.println(res);
            return;
        }
        char ch = str.charAt(0);
        for (int i = 0; i <= res.length(); i++) {
            String f = res.substring(0, i);
            String s = res.substring(i, res.length());
            perm(f + ch + s, str.substring(1));
        }
    }

    public static void main(String[] args) {
        perm("", "abc");
    }
}
