<template>
  <div class="modal" tabindex="-1" id="detailModal">
    <div class="modal-lg modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h1 class="modal-title" style="text-align: center" id="modal-title">
            {{ HouseDetail.AptName }} ( {{ HouseDetail.dong }} )
          </h1>
          <button
            class="btn btn-sm btn-outline-secondary"
            id="btnClose"
            data-dismiss="modal"
            aria-label="Close"
            type="button"
          >
            X
          </button>
        </div>
        <div class="modal-body">
          <div class="modal-text">
            <h1 class="modal-title"></h1>
          </div>
          <table class="table">
            <thead class="" style="color: white; background: #786d64">
              <tr>
                <td style="padding-top: 14px">#</td>
                <td>
                  전용면적
                  <button
                    v-show="isClickArea"
                    class="btn btn-outline-light btn-sm"
                    type="button"
                    @click="sortAreaAscending"
                  >
                    ▼
                  </button>
                  <button
                    v-show="!isClickArea"
                    class="btn btn-outline-light btn-sm"
                    type="button"
                    @click="sortAreaDescending"
                  >
                    ▲
                  </button>
                </td>
                <td style="padding-top: 14px">건축년도</td>
                <td>
                  거래금액
                  <button
                    v-show="isClickDealAmount"
                    class="btn btn-outline-light btn-sm"
                    type="button"
                    @click="sortDealAmountAscending"
                  >
                    ▼
                  </button>
                  <button
                    v-show="!isClickDealAmount"
                    class="btn btn-outline-light btn-sm"
                    type="button"
                    @click="sortDealAmountDescending"
                  >
                    ▲
                  </button>
                </td>
                <td style="padding-top: 14px">거래날짜</td>
                <td style="padding-top: 14px">층수</td>
              </tr>
            </thead>
            <tbody>
              <tr v-for="(HouseDeal, index) in HouseDealList" :key="index">
                <td>{{ index + 1 }}</td>
                <td>{{ HouseDeal.area }}</td>
                <td>{{ HouseDeal.buildYear }}</td>
                <td>{{ HouseDeal.dealAmount }}</td>
                <td>
                  {{ HouseDeal.dealYear }}.{{ HouseDeal.dealMonth }}.{{
                    HouseDeal.dealDay
                  }}
                </td>
                <td>{{ HouseDeal.floor }}</td>
              </tr>

              <tr></tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</template>



<script>
export default {
  data() {
    return {
      isClickArea: true,
      isClickDealAmount: true,
    };
  },
  methods: {
    sortAreaAscending() {
      this.isClickArea = false;
      this.HouseDealList.sort(function (a, b) {
        return a.area - b.area;
      });
    },

    sortAreaDescending() {
      this.isClickArea = true;
      this.HouseDealList.sort(function (a, b) {
        return b.area - a.area;
      });
    },
    sortDealAmountAscending() {
      this.isClickDealAmount = false;
      this.HouseDealList.sort(function (a, b) {
        return a.dealAmount.replace(",", "") - b.dealAmount.replace(",", "");
      });
    },
    sortDealAmountDescending() {
      this.isClickDealAmount = true;
      this.HouseDealList.sort(function (a, b) {
        return b.dealAmount.replace(",", "") - a.dealAmount.replace(",", "");
      });
    },
  },
  created() {},
  computed: {
    HouseDetail() {
      return this.$store.getters.getHouseDetail;
    },
    HouseDealList() {
      return this.$store.getters.getHouseDealList;
    },
  },
};
</script>

<style scoped>
.modal {
  /* position: fixed;
  top: 50%;
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
  -moz-transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  -o-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%); */
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  margin: auto;
  width: 700px;
  height: 700px;
}
.modal-header {
  position: relative;
  margin-top: 10px;
  margin-bottom: 10px;
}
#modal-title {
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  font-size: large;
  font-weight: bold;
  /* padding: 5px 150px 5px 150px; */
}
#btnClose {
  position: absolute;
  top: -5%;
  left: 90%;
  transform: translate(0%, -10%);
}

td,
th {
  text-align: center;
  vertical-align: middle;
}
table {
  margin-left: auto;
  margin-right: auto;
}
</style>