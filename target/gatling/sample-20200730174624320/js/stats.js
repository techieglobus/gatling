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
        "total": "903",
        "ok": "903",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "7014",
        "ok": "7014",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "3959",
        "ok": "3959",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "3056",
        "ok": "3056",
        "ko": "-"
    },
    "percentiles1": {
        "total": "3959",
        "ok": "3959",
        "ko": "-"
    },
    "percentiles2": {
        "total": "5486",
        "ok": "5486",
        "ko": "-"
    },
    "percentiles3": {
        "total": "6708",
        "ok": "6708",
        "ko": "-"
    },
    "percentiles4": {
        "total": "6953",
        "ok": "6953",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 1,
    "percentage": 50
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 1,
    "percentage": 50
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.222",
        "ok": "0.222",
        "ko": "-"
    }
},
contents: {
"req_get-employees-bc13c": {
        type: "REQUEST",
        name: "Get Employees",
path: "Get Employees",
pathFormatted: "req_get-employees-bc13c",
stats: {
    "name": "Get Employees",
    "numberOfRequests": {
        "total": "1",
        "ok": "1",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "7014",
        "ok": "7014",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "7014",
        "ok": "7014",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "7014",
        "ok": "7014",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "0",
        "ok": "0",
        "ko": "-"
    },
    "percentiles1": {
        "total": "7014",
        "ok": "7014",
        "ko": "-"
    },
    "percentiles2": {
        "total": "7014",
        "ok": "7014",
        "ko": "-"
    },
    "percentiles3": {
        "total": "7014",
        "ok": "7014",
        "ko": "-"
    },
    "percentiles4": {
        "total": "7014",
        "ok": "7014",
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
        "total": "0.111",
        "ok": "0.111",
        "ko": "-"
    }
}
    },"req_get-individual--f48f0": {
        type: "REQUEST",
        name: "Get Individual Details Using ID",
path: "Get Individual Details Using ID",
pathFormatted: "req_get-individual--f48f0",
stats: {
    "name": "Get Individual Details Using ID",
    "numberOfRequests": {
        "total": "1",
        "ok": "1",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "903",
        "ok": "903",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "903",
        "ok": "903",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "903",
        "ok": "903",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "0",
        "ok": "0",
        "ko": "-"
    },
    "percentiles1": {
        "total": "903",
        "ok": "903",
        "ko": "-"
    },
    "percentiles2": {
        "total": "903",
        "ok": "903",
        "ko": "-"
    },
    "percentiles3": {
        "total": "903",
        "ok": "903",
        "ko": "-"
    },
    "percentiles4": {
        "total": "903",
        "ok": "903",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 1,
    "percentage": 100
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.111",
        "ok": "0.111",
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
