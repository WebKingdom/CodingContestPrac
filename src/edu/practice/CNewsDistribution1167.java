package edu.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CNewsDistribution1167 {

    private static class FriendStack {
        private int f1;
        private int f2;

        public void nextFriend(int f) {
            f1 = f2;
            f2 = f;
        }
    }

    /**
     * C. News Distribution (CodeForces)
     * Needs faster implementation...
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int users = Integer.parseInt(st.nextToken());
        int groups = Integer.parseInt(st.nextToken());
        HashMap<Integer, ArrayList<Integer>> graphHM = new HashMap<>();
        // Initialize all users
//        for (int i = 1; i <= users; i++) {
//            graphHM.put(i, new ArrayList<>());
//        }

        for (int i = 0; i < groups; i++) {
            st = new StringTokenizer(br.readLine());
            int numFriends = Integer.parseInt(st.nextToken());

            if (numFriends <= 0) {
                continue;
            }
            FriendStack fs = new FriendStack();
            fs.nextFriend(Integer.parseInt(st.nextToken()));

            for (int j = 1; j < numFriends; j++) {
                // Read in friends, put in graph
                fs.nextFriend(Integer.parseInt(st.nextToken()));

                // Add new friend2 to list of friend1
                ArrayList<Integer> edgeList = graphHM.get(fs.f1);
                if (edgeList == null) {
                    edgeList = new ArrayList<Integer>();
                }
                edgeList.add(fs.f2);
                graphHM.put(fs.f1, edgeList);

                // Add friend1 to list of friend2 since undirected graph
                edgeList = graphHM.get(fs.f2);
                if (edgeList == null) {
                    edgeList = new ArrayList<Integer>();
                }
                edgeList.add(fs.f1);
                graphHM.put(fs.f2, edgeList);
            }
        }

        // Keeps track of which group contain which friends for faster retrieve
        HashSet<HashSet<Integer>> hsGroup = new HashSet<>();

        for (int i = 1; i <= users; i++) {
            ArrayList<Integer> al = graphHM.get(i);
            if (al == null || al.isEmpty()) {
                System.out.print(1 + " ");
                continue;
            }

            HashSet<Integer> curHS = hsContains(hsGroup, i);
            int numConn = curHS == null ? 1 : curHS.size();

            if (numConn <= 1) {
                HashSet<Integer> visitedVertices = new HashSet<>();
                visitedVertices.add(i);

                Queue<Integer> q = new LinkedList<>(al);

                while (!q.isEmpty()) {
                    int curVertex = q.poll();
                    if (!visitedVertices.contains(curVertex)) {
                        numConn++;
                        // TODO making it worse? Add new non-visited vertices to queue
//                        for (int vertex : graphHM.get(curVertex)) {
//                            if (!visitedVertices.contains(vertex)) {
//                                q.add(vertex);
//                            }
//                        }
                        q.addAll(graphHM.get(curVertex));
                        visitedVertices.add(curVertex);
                    }
                }
                hsGroup.add(visitedVertices);
            }
            System.out.print(numConn + " ");
        }
    }

    private static HashSet<Integer> hsContains(HashSet<HashSet<Integer>> hs, int val) {
        for (HashSet<Integer> curHS : hs) {
            if (curHS.contains(val)) {
                return curHS;
            }
        }
        return null;
    }
}
