var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "2",
        "ok": "2",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "1228",
        "ok": "1228",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "9007",
        "ok": "9007",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "5118",
        "ok": "5118",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "3890",
        "ok": "3890",
        "ko": "-"
    },
    "percentiles1": {
        "total": "5118",
        "ok": "5118",
        "ko": "-"
    },
    "percentiles2": {
        "total": "7062",
        "ok": "7062",
        "ko": "-"
    },
    "percentiles3": {
        "total": "8618",
        "ok": "8618",
        "ko": "-"
    },
    "percentiles4": {
        "total": "8929",
        "ok": "8929",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 2,
    "percentage": 100
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.182",
        "ok": "0.182",
        "ko": "-"
    }
},
contents: {
"req_get-all-employe-8e6d0": {
        type: "REQUEST",
        name: "Get All Employees",
path: "Get All Employees",
pathFormatted: "req_get-all-employe-8e6d0",
stats: {
    "name": "Get All Employees",
    "numberOfRequests": {
        "total": "1",
        "ok": "1",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "9007",
        "ok": "9007",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "9007",
        "ok": "9007",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "9007",
        "ok": "9007",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "0",
        "ok": "0",
        "ko": "-"
    },
    "percentiles1": {
        "total": "9007",
        "ok": "9007",
        "ko": "-"
    },
    "percentiles2": {
        "total": "9007",
        "ok": "9007",
        "ko": "-"
    },
    "percentiles3": {
        "total": "9007",
        "ok": "9007",
        "ko": "-"
    },
    "percentiles4": {
        "total": "9007",
        "ok": "9007",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 1,
    "percentage": 100
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.091",
        "ok": "0.091",
        "ko": "-"
    }
}
    },"req_get-our-employe-1f37a": {
        type: "REQUEST",
        name: "Get Our Employee",
path: "Get Our Employee",
pathFormatted: "req_get-our-employe-1f37a",
stats: {
    "name": "Get Our Employee",
    "numberOfRequests": {
        "total": "1",
        "ok": "1",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "1228",
        "ok": "1228",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1228",
        "ok": "1228",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "1228",
        "ok": "1228",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "0",
        "ok": "0",
        "ko": "-"
    },
    "percentiles1": {
        "total": "1228",
        "ok": "1228",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1228",
        "ok": "1228",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1228",
        "ok": "1228",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1228",
        "ok": "1228",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 1,
    "percentage": 100
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.091",
        "ok": "0.091",
        "ko": "-"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
