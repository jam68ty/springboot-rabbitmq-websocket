package com.example.websocketrabbitmqdemo.utils.pagination;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class OffsetBasedPageRequest implements Pageable {
    private int offset;
    private int limit;
    private Sort sort;

    public OffsetBasedPageRequest(int offset, int limit, Sort sort) {
        this.offset = offset;
        this.limit = limit;
        this.sort = sort;
    }

    @Override
    public int getPageNumber () {
        return offset / limit;
    }

    @Override
    public int getPageSize () {
        return limit;
    }

    @Override
    public long getOffset () {
        return offset;
    }

    @Override
    public Sort getSort () {
        return sort;
    }

    @Override
    public Pageable next () {
        return new OffsetBasedPageRequest((int) (getOffset() + getPageSize()), getPageSize(), sort);
    }

    @Override
    public Pageable previousOrFirst () {
        return hasPrevious()
                ? new OffsetBasedPageRequest((int) (getOffset() - getPageSize()), getPageSize(), sort)
                : this;
    }

    @Override
    public Pageable first () {
        return new OffsetBasedPageRequest(0, getPageSize(), sort);
    }

    @Override
    public Pageable withPage(int pageNumber) {
        return null;
    }

    @Override
    public boolean hasPrevious () {
        return offset > limit;
    }
}
