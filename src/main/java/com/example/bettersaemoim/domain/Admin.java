package com.example.bettersaemoim.domain;

import com.example.bettersaemoim.domain.enums.UserRoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 자동 지정
    private Long id;
    @Column(nullable = false, unique = true) // 제약조건
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING) // Enum을 문자열로 매핑
    private UserRoleEnum role;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = UserRoleEnum.ADMIN;
    }

    public boolean isRootAdmin() {
        return this.getRole().equals(UserRoleEnum.ROOT);
    }
}
