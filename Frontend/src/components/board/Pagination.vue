<template>
  <!-- a tag href="#" 제외!!
route url 이 board 에서 / 로 변경되는 문제 발생 -->
  <nav aria-label="Page navigation">
    <ul class="pagination justify-content-center">
      <li v-if="prev" class="page-item">
        <a
          class="page-link"
          href="#"
          aria-label="Previous"
          @click="paginationChanged(startPageIndex - 1)"
          style="color: #786d64"
        >
          <span aria-hidden="true">«</span>
        </a>
      </li>
      <li
        v-for="index in endPageIndex - startPageIndex + 1"
        :key="index"
        v-bind:class="{
          active:
            startPageIndex + index - 1 == $store.state.board.currentPageIndex,
        }"
      >
        <a
          @click="paginationChanged(startPageIndex + index - 1)"
          class="page-link"
          style="color: #786d64"
          href="#"
          >{{ startPageIndex + index - 1 }}</a
        >
        <!-- href 는 그대로, 커서 모양 유지-->
      </li>
      <li v-if="next" class="page-item">
        <a
          class="page-link"
          href="#"
          aria-label="Next"
          @click="paginationChanged(endPageIndex + 1)"
          style="color: #786d64"
        >
          <span aria-hidden="true">»</span>
        </a>
      </li>
    </ul>
  </nav>
</template>


<script>
export default {
  name: "Pagination",
  // props 사용 X
  // props: ['listRowCount', 'pageLinkCount', 'currentPageIndex', 'totalListItemCount'],
  data() {
    return {};
  },
  computed: {
    pageCount: function () {
      return this.$store.getters.getPageCount;
    },
    startPageIndex: function () {
      return this.$store.getters.getStartPageIndex;
    },
    endPageIndex: function () {
      return this.$store.getters.getEndPageIndex;
    },
    prev: function () {
      return this.$store.getters.getPrev;
    },
    next: function () {
      return this.$store.getters.getNext;
    },
  },
  methods: {
    // 부모에게 event 전달
    paginationChanged(pageIndex) {
      console.log(
        "paginationVue : paginationChanged : pageIndex : " + pageIndex
      );
      this.$emit("call-parent", pageIndex);
    },
  },
};
</script>

<style scpoed>
.pagination > .active > li,
.pagination > .active > a:link,
.pagination > .active > a:focus,
.pagination > .active {
  color: white !important;
  background-color: #786d64;
  border-color: #786d64;
}

.page-item {
  color: white !important;
  background-color: #786d64 !important;
  border-color: #786d64 !important;
}
</style>

