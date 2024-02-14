import React, { useEffect, useState } from "react";
import styled from "styled-components";
import vote from "../../../assets/vote.png";
import axiosInstance, { endpoints } from "../../../axios";

const ButtonImage = styled.img`
  width: 12px;
  height: 12px;
  margin-left: 10px;
`;
const LikeCounted = styled.p`
  display: inline-block;
  color: #c62917;
  font-size: 13px;
  padding-left: 4px;
`;

function LikeButton({ boardId, boardTitle, boardContent, boardWriter }) {
  const userFrom = localStorage.getItem("userId");
  const [likeCounts, setLikeCounts] = useState(0);
  const [userLiked, setUserLiked] = useState(false);

  let variables = {
    memberId: userFrom,
    postId: boardId,
    // boardWriter: boardWriter,
    // boardTitle: boardTitle,
    // boardContent: boardContent,
  };

  const getLikeInfo = () => {
    axiosInstance
      .post("/like/likeCounts", variables)
      .then((response) => {
        if (!response.data.success) {
          alert("좋아요 정보를 가져오는데 실패했습니다.");
          return;
        }
        let responsedData = response.data.likeCounts;
        setLikeCounts(responsedData);
      })
      .catch((e) => console.log(e));
  };

  const ifUserHasLiked = () => {
    axiosInstance
      .post(endpoints.like.like, variables)
      .then((response) => {
        if (!response.data.success) {
          alert("좋아요 정보를 가져오는데 실패했습니다.");
          return;
        }
        let responsedData = response.data.liked;
        setUserLiked(responsedData);
      })
      .catch((e) => console.log(e));
  };

  const changeToDislike = () => {
    axiosInstance
      .post(endpoints.like.dislike, variables)
      .then((response) => {
        if (!response.data.success) {
          alert("좋아요 삭제를 실패했습니다.");
          return;
        }
        setLikeCounts(likeCounts - 1);
      })
      .catch((e) => console.log(e));
  };

  const changeToLike = () => {
    axiosInstance
      .post(endpoints.like.change, variables)
      .then((response) => {
        if (!response.data.success) {
          alert("좋아요 등록을 실패했습니다.");
          return;
        }
        setLikeCounts(likeCounts + 1);
      })
      .catch((e) => console.log(e));
  };

  const handleLike = (event) => {
    event.preventDefault();
    userLiked ? changeToDislike() : changeToLike();
  };

  useEffect(() => {
    getLikeInfo();
    ifUserHasLiked();
  }, [likeCounts, userLiked]);

  return (
    <>
      <button onClick={handleLike}>
        <ButtonImage src={vote} alt="vote" />
        <LikeCounted>{likeCounts}</LikeCounted>
      </button>
    </>
  );
}

export default LikeButton;
