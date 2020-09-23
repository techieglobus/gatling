var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "3",
        "ok": "3",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "5020",
        "ok": "5020",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "5987",
        "ok": "5987",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "5585",
        "ok": "5585",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "411",
        "ok": "411",
        "ko": "-"
    },
    "percentiles1": {
        "total": "5747",
        "ok": "5747",
        "ko": "-"
    },
    "percentiles2": {
        "total": "5867",
        "ok": "5867",
        "ko": "-"
    },
    "percentiles3": {
        "total": "5963",
        "ok": "5963",
        "ko": "-"
    },
    "percentiles4": {
        "total": "5982",
        "ok": "5982",
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
    "count": 3,
    "percentage": 100
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.429",
        "ok": "0.429",
        "ko": "-"
    }
},
contents: {
"req_create-a-user-22ef6": {
        type: "REQUEST",
        name: "create a user",
path: "create a user",
pathFormatted: "req_create-a-user-22ef6",
stats: {
    "name": "create a user",
    "numberOfRequests": {
        "total": "3",
        "ok": "3",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "5020",
        "ok": "5020",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "5987",
        "ok": "5987",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "5585",
        "ok": "5585",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "411",
        "ok": "411",
        "ko": "-"
    },
    "percentiles1": {
        "total": "5747",
        "ok": "5747",
        "ko": "-"
    },
    "percentiles2": {
        "total": "5867",
        "ok": "5867",
        "ko": "-"
    },
    "percentiles3": {
        "total": "5963",
        "ok": "5963",
        "ko": "-"
    },
    "percentiles4": {
        "total": "5982",
        "ok": "5982",
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
    "count": 3,
    "percentage": 100
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.429",
        "ok": "0.429",
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
