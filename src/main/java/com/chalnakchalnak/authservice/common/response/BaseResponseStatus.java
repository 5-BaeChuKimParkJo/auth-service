package com.chalnakchalnak.authservice.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@AllArgsConstructor
public enum BaseResponseStatus {

    /**
     * 200: 요청 성공
     **/
    SUCCESS(HttpStatus.OK, true, 200, "요청에 성공하였습니다."),
    SUCCESS_SEND_VERIFICATION_CODE(HttpStatus.OK, true, 201, "인증번호 전송에 성공하였습니다."),
    SUCCESS_VERIFIED_CODE(HttpStatus.OK, true, 202, "인증번호가 일치합니다."),
    SUCCESS_SIGN_UP(HttpStatus.OK, true, 203, "회원가입에 성공하였습니다."),


    /**
     * 400 : security 에러
     */
    WRONG_TOKEN(HttpStatus.UNAUTHORIZED, false, 401, "토큰이 유효하지 않습니다"),
    NO_SIGN_IN(HttpStatus.UNAUTHORIZED, false, 402, "로그인을 먼저 진행해주세요"),


    /**
     * 900: 기타 에러
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, false, 900, "Internal server error"),
    SSE_SEND_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, false, 901, "알림 전송에 실패하였습니다."),
    FAILED_SEND_SMS(HttpStatus.INTERNAL_SERVER_ERROR, false, 902, "SMS 전송에 실패하였습니다."),
    LOGIN_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, false, 903, "로그인에 실패하였습니다."),

    /**
     * 1000: Request 유효성 에러
     */
    INVALID_REQUEST(HttpStatus.BAD_REQUEST, false, 1000, "잘못된 요청입니다."),


    /**
     * 2000: 인증 관련 에러
     */
    EXPIRED_VERIFICATION_CODE(HttpStatus.BAD_REQUEST, false, 2000, "인증번호가 만료되었습니다. 다시 인증코드를 요청해주세요."),
    FAIL_VERIFIED_CODE(HttpStatus.BAD_REQUEST, false, 2001, "인증번호가 일치하지 않습니다."),
    SEND_LIMITED(HttpStatus.TOO_MANY_REQUESTS, false, 2002, "인증코드 발송은 3분에 1회 가능합니다. 잠시 후 다시 시도해주세요."),
    VERIFICATION_LIMITED(HttpStatus.TOO_MANY_REQUESTS, false, 2003, "5회 실패하여 인증코드가 만료되었습니다. 다시 인증코드를 요청해주세요."),
    FAILED_TO_LOGIN(HttpStatus.UNAUTHORIZED, false, 2010, "아이디 또는 패스워드를 다시 확인하세요."),
    SIGN_UP_NOT_VERIFIED(HttpStatus.BAD_REQUEST, false, 2020, "회원가입을 위해 본인인증을 진행해주세요.");


    private final HttpStatusCode httpStatusCode;
    private final boolean isSuccess;
    private final int code;
    private final String message;

}
