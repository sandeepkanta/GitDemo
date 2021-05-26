package com.lendingkart;

public class TestElection {

    Election election = new Election();

    public boolean testFindWinnerInTheElection(String[] votes, String winner){
        String actual = election.findWinnerInTheElection(votes);
        return actual.equals(winner);
    }

    public boolean testFindWinnerInTheElection(String[][] votes, String winner){
        String actual = election.findWinnerInTheElection(votes);
        return actual.equals(winner);
    }

    public static void main(String[] args) {
        TestElection testElection = new TestElection();
        String votes[] = {"C1", "C2", "C3", "C1", "C2"};
        System.out.println(testElection.testFindWinnerInTheElection(votes, "C2"));
        votes = new String[]{"C1", "C2", "C3", "C1", "C1"};
        System.out.println(testElection.testFindWinnerInTheElection(votes, "C1"));
        //no tie
        String votesByPerson[][] = {{"C1", "C2", "C3"}, {"C3", "C1", "C2"}};
        System.out.println(testElection.testFindWinnerInTheElection(votesByPerson, "C1"));
        // tie case
        votesByPerson = new String[][]{{"C2", "C1", "C3"}, {"C1", "C2", "C2"}};
        System.out.println(testElection.testFindWinnerInTheElection(votesByPerson, "C2"));

    }


}
