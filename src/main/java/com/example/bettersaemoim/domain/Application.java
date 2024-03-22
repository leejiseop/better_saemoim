package com.example.bettersaemoim.domain;

import com.example.bettersaemoim.domain.enums.ApplicationStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Application extends TimeStamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ApplicationStatusEnum status;

    public Application(User user, Group group) {
        this.user = user;
        this.group = group;
        this.status = ApplicationStatusEnum.WAIT;
    }

    public Long getGroupId() {
        return this.group.getId();
    }

    public String getGroupName() {
        return this.group.getName();
    }

    public String getLeaderName() {
        return this.group.getUsername();
    }

    public Long getUserId() {
        return this.user.getId();
    }

    public String getUsername() {
        return this.user.getUsername();
    }

    public boolean isRightUserWhoApplied(Long userId) {
        return this.getUserId().equals(userId);
    }

    public void permit() {
        this.status = ApplicationStatusEnum.PERMIT;
    }

    public void reject() {
        this.status = ApplicationStatusEnum.REJECT;
    }

    public boolean isWait() {
        return this.status.equals(ApplicationStatusEnum.WAIT);
    }
}
