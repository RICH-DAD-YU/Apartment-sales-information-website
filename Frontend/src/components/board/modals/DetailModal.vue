<template>
  <div class="modal" tabindex="-1" id="detailModal">
    <div class="modal-dialog">
      <div class="modal-content" style="width: 1000px; height: 1000px">
        <div class="modal-header">
          <h5
            class="modal-title"
            style="font-weight: bold; font-size: x-large; text-align: center"
          >
            글 상세
          </h5>
          <button
            class="btn btn-sm"
            data-dismiss="modal"
            aria-label="Close"
            type="button"
            style="color: #786d64"
          >
            X
          </button>
        </div>
        <div class="modal-body">
          <table class="table table-hover">
            <tbody>
              <tr>
                <td style="width: 10px">글번호</td>
                <td>{{ $store.state.board.boardId }}</td>
              </tr>
              <tr>
                <td style="width: 120px">제목</td>
                <td>{{ $store.state.board.title }}</td>
              </tr>
              <tr>
                <td style="width: 120px">내용</td>
                <td v-html="$store.state.board.content"></td>
              </tr>
              <tr>
                <td style="width: 120px">작성자</td>
                <td>{{ $store.state.board.userName }}</td>
              </tr>
              <!-- 아래 코드는 오류 발생 초기 생성 시점에 regDt = {} -->
              <!-- <tr><td>작성일시</td><td>{{ makeDateStr(regDt.date.year, regDt.date.month, regDt.date.day, '.') }}</td></tr> -->
              <tr>
                <td>작성일시</td>
                <td>
                  {{ $store.state.board.regDate }}
                  {{ $store.state.board.regTime }}
                </td>
              </tr>
              <tr>
                <td>조회수</td>
                <td>{{ $store.state.board.readCount }}</td>
              </tr>
              <!-- New for FileUpload -->
              <tr>
                <td colspan="2">첨부파일</td>
              </tr>
              <tr v-if="$store.state.board.fileList.length > 0">
                <td colspan="2">
                  <div
                    v-for="(file, index) in $store.state.board.fileList"
                    :key="index"
                  >
                    <span class="fileName">{{ file.fileName }}</span>

                    <a
                      type="button"
                      class="btn btn-outline btn-default btn-xs"
                      v-bind:href="file.fileUrl"
                      v-bind:download="file.fileName"
                      >내려받기</a
                    >
                  </div>
                </td>
              </tr>
              <!-- / New for FileUpload -->
            </tbody>
          </table>
        </div>
        <div class="modal-footer">
          <button
            v-show="$store.state.board.sameUser"
            @click="changeToUpdate"
            class="btn btn-sm btn-outline"
            data-dismiss="modal"
            type="button"
            style="color: white; background: #786d64"
          >
            글 수정하기
          </button>
          <button
            v-show="$store.state.board.sameUser"
            @click="changeToDelete"
            class="btn btn-sm btn-outline"
            data-dismiss="modal"
            type="button"
            style="color: #786d64"
          >
            글 삭제하기
          </button>
        </div>
      </div>
    </div>
  </div>
</template>


<script>
export default {
  methods: {
    changeToUpdate() {
      this.$emit("call-parent-change-to-update");
    },
    changeToDelete() {
      this.$emit("call-parent-change-to-delete");
    },
  },
};
</script>


<style scoped>
</style>