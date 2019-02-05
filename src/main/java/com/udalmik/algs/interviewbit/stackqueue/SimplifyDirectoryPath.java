package com.udalmik.algs.interviewbit.stackqueue;


import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://www.interviewbit.com/problems/simplify-directory-path/
 */
public class SimplifyDirectoryPath {


    /**
     * path = "/home/", => "/home"
     * path = "/a/./b/../../c/", => "/c"
     */
    public String simplifyPath(String path) {

        LinkedList<String> pathQueue = new LinkedList<>();

        String[] tokens = path.split("\\/+");

        Stream.of(tokens)
                .filter(s -> !s.isEmpty())
                .forEach(token -> {
                    switch (token) {
                        case ".":
                            break;
                        case "..":
                            pathQueue.pollLast();
                            break;
                        default:
                            pathQueue.add(token);
                            break;
                    }
                });

        return pathQueue
                .stream()
                .collect(Collectors.joining("/", "/", ""));

    }
}
