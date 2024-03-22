package com.example.bettersaemoim.domain;

import com.example.bettersaemoim.domain.enums.BlacklistStatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class BlackList extends TimeStamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BlacklistStatusEnum status;

    public Long getUserId() {
        return user.getId();
    }

    public String getUsername() {
        return user.getUsername();
    }

    public Integer getBanCount() {
        return user.getBanCount();
    }

    public void updateStatus(BlacklistStatusEnum status) {
        this.status = status;
    }

    public BlackList(User user, BlacklistStatusEnum status) {
        this.user = user;
        this.status = status;
    }
}
