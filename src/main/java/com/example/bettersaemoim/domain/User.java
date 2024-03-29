package com.example.bettersaemoim.domain;

import com.example.bettersaemoim.domain.enums.UserRoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name = "users")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User extends TimeStamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String content = "안녕하세요. 잘 부탁드립니다.";

    @Column(nullable = false)
    private int banCount = 0;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;

    @Column
    private Long kakaoId;

    @Column(nullable = false)
    private String imagePath = "/resources/static/images/default_profile.jpg";

    public User(String email, String password, String username, UserRoleEnum role) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.role = role;
    }

    public User(String email, String password, String username, UserRoleEnum role, Long kakaoId) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.role = role;
        this.kakaoId = kakaoId;
    }

    public void plusBanCount() {
        this.banCount++;
    }

    public void updateStatus(UserRoleEnum role) {
        this.role = role;
    }

    public boolean isBanned() {
        return this.role.equals(UserRoleEnum.REPORT);
    }

    public void updatePasswordToTemp(String password) {
        this.password = password;
    }

    public void updateProfile(String content) {
        this.content = content;
    }

    public void updateProfile(String content, String imagePath) {
        this.content = content;
        this.imagePath = imagePath;
    }

    public User updateKakaoId(Long kakaoId) {
        this.kakaoId = kakaoId;
        return this;
    }
}
