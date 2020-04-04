package com.gbs.thread.forkjoin.actionwithpool;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class FindFiles extends RecursiveAction {
    private File path;

    public FindFiles(File sFile) {
        this.path = sFile;
    }

    @Override
    protected void compute() {

        List<FindFiles> subTasks = new ArrayList<>();
        File[] files = path.listFiles();
        if(files != null)
        {
            for(File file : path.listFiles()) {
                if(file.isDirectory())
                    subTasks.add(new FindFiles(file));
                else
                    if(file.getName().endsWith("txt"))
                        System.out.println(file.getAbsoluteFile());
            }
            if(!subTasks.isEmpty()) {
                for(FindFiles subTask: invokeAll(subTasks))
                {
                    subTask.join();
                }
            }
        }
    }

    public static void main(String[] args) {

        try {
            ForkJoinPool forkJoinPool = new ForkJoinPool();
            FindFiles task = new FindFiles(new File( "/users"));

            forkJoinPool.execute(task);

            System.out.println("main is working");
            task.join();
            System.out.println("Task end");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
