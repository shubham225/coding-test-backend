package com.shubham.onlinetest.model.entity;

import com.shubham.onlinetest.model.enums.ProblemDifficulty;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Problem extends BaseModel {
    @Column(unique = true)
    private String urlCode;
    private String title;
    @Enumerated(EnumType.ORDINAL)
    private ProblemDifficulty difficulty;
    @Column(columnDefinition = "TEXT")
    private String descriptionMd;
    private String testCasesPath;
    private Boolean isActive;
    @OneToMany(mappedBy = "problem", cascade = CascadeType.ALL)
    private List<CodeSnippet> codeSnippets = new ArrayList<>();
    private long maxExecutionTime;
}
