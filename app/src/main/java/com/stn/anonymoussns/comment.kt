package com.stn.anonymoussns

class comment {
    /**
     * 댓글의 아이디
     */
    var commentId = ""

    /**
     * 댓글의 대상이 되는 글의 ID
     */
    var postId = ""

    /**
     * 댓글 작성자의 ID
     */
    var writerId = ""

    /**
     * 댓글 내용
     */
    var message = ""

    /**
     * 작성시간
     */
    var writeTime: Any = Any()

    /**
     * 배경이미지
     */
    var bgUri = ""
}