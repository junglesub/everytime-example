import axios from "axios";
// config
export const BASE_URL = process.env.REACT_APP_BASE_URL;

// ----------------------------------------------------------------------

const axiosInstance = axios.create({
  baseURL: BASE_URL,
  withCredentials: true,
});

axiosInstance.interceptors.response.use(
  (res) => res,
  (error) =>
    Promise.reject(
      (error.response && error.response.data) || "Something went wrong"
    )
);

export default axiosInstance;

// ----------------------------------------------------------------------

export const fetcher = async (args) => {
  const [url, config] = Array.isArray(args) ? args : [args];

  const res = await axiosInstance.get(url, { ...config });

  return res.data;
};

// ----------------------------------------------------------------------
export const endpoints = {
  auth: {
    login: "/auth/sign-in", // post, 로그인
    register: "/auth/sign-up", // post, 회원가입
    logout: "/auth/sign-out", // get, 로그아웃
    auth: "/auth", // get, 인증
    check: "/auth/sign-up/validation", // get, 회원가입시 아이디 중복체크
  },
  comment: {
    list: "/comment/getComment", // get, 댓글 목록 가져오기
    mine: "/comment/comments", // get, 내가 작성한 댓글 목록 가져오기
    create: "/comment/upload", // post, 댓글 작성
    delete: "/comment/deleteComment", // delete, 댓글 삭제
  },
  board: {
    list: "/posts", // get, 게시글 목록 가져오기
    details: "/posts", // get, 게시글 상세보기
    create: "/posts", // post, 게시글 작성
    delete: "/posts", // delete, 게시글 삭제
    mine: "", // get, ??
  },
  like: {
    like: "/likes", // post // 공감하기
    dislike: "/likes", // post // 공감취소하기
    change: "/like", // post // 공감 변경하기
    list: "/likes", // get // 공감 목록 가져오기
  },
  user: {
    profile: "/members/profile/my", // get // 프로필 가져오기
    info: "/user", // get // 유저 정보 가져오기
    update: "/user/update/email", // post // 유저 정보 수정
    board: "/user/myBoard", // get // 내가 작성한 게시글 목록 가져오기
    updateNickname: "/user/update/nickname", // put // 닉네임 변경
    updatePassword: "/user/update/password", // put // 비밀번호 변경
    delete: "/user/delete", // delete // 회원탈퇴
  },
};
