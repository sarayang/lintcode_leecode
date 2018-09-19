package lintcode.lintcode_leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by YANGSONG on 2018-09-19.
 */
public class Accounts_Merge {
    HashMap<Integer, Integer> father = new HashMap<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList<>();

        HashMap<String, ArrayList> emailToIndices = getEmailToIndices(accounts);
        System.out.println(emailToIndices);
        for (String email : emailToIndices.keySet()) {
            ArrayList<Integer> indices = emailToIndices.get(email);

            for (int i = 1; i < indices.size(); i++) {
                connect(indices.get(i), indices.get(0));
            }
        }

        HashMap<Integer, HashSet> indexToEmails = getIndexToEmails(accounts);
        for (Integer index : indexToEmails.keySet()) {
            ArrayList<String> emails = new ArrayList<>(indexToEmails.get(index));
            Collections.sort(emails);
            emails.add(0, accounts.get(index).get(0));
            result.add(emails);
        }
        return result;
    }

    // need to union all the indices in ArrayList
    private HashMap<String, ArrayList> getEmailToIndices(List<List<String>> accounts) {
        HashMap<String, ArrayList> emailToIndices = new HashMap<>();

        for (int index = 0; index < accounts.size(); index++) {
            List<String> account = accounts.get(index);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                ArrayList<Integer> indices = emailToIndices.getOrDefault(email, new ArrayList<>());
                indices.add(index);
                emailToIndices.put(email, indices);
            }
        }
        return emailToIndices;
    }

    private HashMap<Integer, HashSet> getIndexToEmails(List<List<String>> accounts) {
        HashMap<Integer, HashSet> indexToEmails = new HashMap<>();
        for (int index = 0; index < accounts.size(); index++) {

            List<String> account = accounts.get(index);
            int root = find(index);
            HashSet<String> emails = indexToEmails.getOrDefault(root, new HashSet<>());
            for (int i = 1; i < account.size(); i++) {
                emails.add(account.get(i));
            }

            indexToEmails.put(root, emails);
        }

        return indexToEmails;
    }

    private int find(int a) {
        ArrayList<Integer> path = new ArrayList<>();
        while (father.containsKey(a)) {
            path.add(a);
            a = father.get(a);
        }

        for (Integer i : path) {
            father.put(i, a);
        }

        return a;
    }

    private void connect(int n1, int n2) {
        int r1 = find(n1);
        int r2 = find(n2);
        if (r1 != r2) {
            father.put(r1, r2);
        }
    }
}
