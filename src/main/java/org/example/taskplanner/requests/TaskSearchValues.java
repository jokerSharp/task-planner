package org.example.taskplanner.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskSearchValues {

    private String title;
    private Boolean completed;
    private Long priorityId;
    private Long categoryId;
    private String email;

    private Date dateFrom;
    private Date dateTo;

    private Integer pageNumber;
    private Integer pageSize;

    private String sortColumn;
    private String sortDirection;
}
