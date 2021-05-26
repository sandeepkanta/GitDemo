package com.lendingkart;
/*
a). Who is the winner of the election:  Given a List of votes for all candidates  [C1, C2, C1, C2, C3, C2] decide the winner # answer (winner is  C2 with 3 votes).
b). Each  person can give 3 different votes and considering  the 1st  vote is 3 points 2nd vote is 2 and 3rd vote is 1 point  decide the  winner; Ex   P1 : [C2, C3, C1] , P2 : [C4, C2, C1] So here the winner is  C2  with 5 points; (C1: 2, C2: 5, C3: 2, C4:3);
c). print 1st n candidates getting the highest no of votes.*/

/*
  C1,C2,C1,C3,C2
  winner - C2
 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Election {

    class CandidateVoteCount{
        String candidate;
        Integer voteCount;
        CandidateVoteCount(String candidate, Integer voteCount){
            this.candidate = candidate;
            this.voteCount = voteCount;
        }
    }



    String  findWinnerInTheElection(String [] votes)
    {
        Map<String, Integer>  candidateVoteCount = new HashMap<>();
        String winner=null;
        int n = votes.length;
        for(int i=0;i<n;i++){
            String candidate = votes[i];
            int voteCountForCandidate = candidateVoteCount.getOrDefault(candidate, 0);
            voteCountForCandidate+=1;
            candidateVoteCount.put(candidate, voteCountForCandidate);
            int voteCountForWinner = candidateVoteCount.getOrDefault(winner, 0);
            if(voteCountForWinner <= voteCountForCandidate){
                winner = candidate;
            }
        }
        return winner;
    }

    String findWinnerInTheElection(String[][] votesByPerson)
    {
        Map<String, Integer>  candidateVoteCount = new HashMap<>();
        String winner=null;
        int [] preferenceArray = {3, 2, 1};
        int m = votesByPerson.length;
        for(int i=0;i<m;i++){
            for(int j=0;j<2;j++){
                String candidate = votesByPerson[i][j];
                int voteCountForCandidate = candidateVoteCount.getOrDefault(candidate, 0);
                voteCountForCandidate += preferenceArray[j];
                int voteCountForWinner = candidateVoteCount.getOrDefault(winner, 0);
                if(voteCountForWinner <= voteCountForCandidate){
                    winner = candidate;
                }
            }
        }
        return winner;
    }

    void firstNCandidates(String [] votes, int k){
        Map<String, Integer>  candidateVoteCount = new HashMap<>();

        int maxVoteCount=Integer.MIN_VALUE;
        int n = votes.length;
        for(int i=0;i<n;i++){
            String candidate = votes[i];
            int voteCountForCandidate = candidateVoteCount.getOrDefault(candidate, 0);
            voteCountForCandidate+=1;
            candidateVoteCount.put(candidate, voteCountForCandidate);
            if(maxVoteCount < voteCountForCandidate)
                maxVoteCount = voteCountForCandidate;
        }

        var queue = new PriorityQueue<CandidateVoteCount>(k, (CandidateVoteCount candidateVoteCount1, CandidateVoteCount candidateVoteCount2) -> {
            return  candidateVoteCount1.voteCount - candidateVoteCount2.voteCount;
        });
        for(String candidate: candidateVoteCount.keySet()){
            var currentCandidate = new CandidateVoteCount(candidate, candidateVoteCount.get(candidate));
            if(queue.size() < k){
                queue.add(currentCandidate);
            }else if(queue.peek().voteCount < currentCandidate.voteCount){
                queue.remove();
                queue.add(currentCandidate);
            }
        }
        while (!queue.isEmpty()){
            System.out.println(queue.peek().candidate);
        }

    }



}
