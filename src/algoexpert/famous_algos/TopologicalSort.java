package algoexpert.famous_algos;

import util.Utils;

import javax.print.attribute.standard.JobName;
import java.util.*;

public class TopologicalSort {

    public static void main(String[] args) {

        List<Integer> jobs = new ArrayList<>(Arrays.asList(new Integer[]{1,2,3,4}));
        List<Integer[]> deps = new ArrayList<>();
        Integer[] i1 = new Integer[]{1,2};
        Integer[] i2 = new Integer[]{1,3};
        Integer[] i3 = new Integer[]{3,2};
        Integer[] i4 = new Integer[]{4,2};
        Integer[] i5 = new Integer[]{4,3};
        deps.add(i1);
        deps.add(i2);
        deps.add(i3);
        deps.add(i4);
        deps.add(i5);

        Utils.print(topologicalSort(jobs,deps));
    }

    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
        JobGraph jobGraph = new JobGraph(jobs,deps);
        return getOrderedJobs(jobGraph);
    }

    private static List<Integer> getOrderedJobs(JobGraph jobGraph) {

        List<Integer> result = new ArrayList<>();

        List<JobNode> jobNodes = jobGraph.nodes;

        while (jobNodes.size() > 0){
            JobNode jobNode = jobNodes.get(jobNodes.size() - 1);
            jobNodes.remove(jobNodes.size() - 1);
            Boolean hasCycle = depthFirstTraverse(jobNode,result);
            if(hasCycle) return new ArrayList<>();
        }

        return result;
    }

    public static Boolean depthFirstTraverse(JobNode jobNode,List<Integer> result){
        if(jobNode.visiting == true){
            return true;
        }else if(jobNode.visited == true){
            return false;
        }
        jobNode.visiting = true;
        for(JobNode jobNode1 : jobNode.prereqs){
            Boolean hasCycle = depthFirstTraverse(jobNode1,result);
            if(hasCycle) return true;
        };
        jobNode.visiting =false;
        jobNode.visited = true;
        result.add(jobNode.job);
        return false;
    }

    public static class JobGraph{

        List<JobNode> nodes;
        Map<Integer,JobNode> graph;

        JobGraph(List<Integer> jobs, List<Integer[]> deps){
            this.nodes = new ArrayList<JobNode>();
            Map<Integer,JobNode> newGraph = new HashMap<>();
            jobs.forEach(n ->{
                newGraph.put(n,new JobNode(n));
                this.nodes.add(newGraph.get(n));
            });
            this.graph = newGraph;
            deps.forEach( d ->{
                JobNode node =  graph.get(d[1]);
                JobNode dependency = graph.get(d[0]);
                node.addPrereq(dependency);
            });
        }
    }

    public static class JobNode{

        Integer job;
        List<JobNode> prereqs;
        Boolean visited;
        Boolean visiting;

        JobNode(Integer job, List<JobNode> prereq){
            this.job = job;
            this.prereqs = prereq;
            visited = false;
            visiting = false;
        }
        JobNode(Integer job){
            this.job = job;
            visited = false;
            visiting = false;
            this.prereqs = new ArrayList<>();
        }

        public void addPrereq(JobNode req){
            prereqs.add(req);
        }

    }
}
