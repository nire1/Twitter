package com.example.twitter.mapper;

public interface Mapper<D, S> {
    D map(S source);
}
