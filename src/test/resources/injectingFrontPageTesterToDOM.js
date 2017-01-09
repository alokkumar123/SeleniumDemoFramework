var fileref = document.createElement('script');
fileref.setAttribute("type", "text/javascript");
fileref.setAttribute("src", "http://squizlabs.github.io/HTML_CodeSniffer/build/HTMLCS.js");
document.getElementsByTagName("head")[0].appendChild(fileref);

setTimeout(function () {
    fileref = document.createElement('div');
    fileref.setAttribute("id", "resultsWrapper");
    fileref.setAttribute("style", "position:absolute;bottom:0;z-index:9999999999;background-color: antiquewhite;");
    document.getElementsByTagName("body")[0].appendChild(fileref);
    setTimeout(function () {
        var standard = "WCAG2AA";
        var resultsWrapper = document.getElementById('resultsWrapper');
        var source = new XMLSerializer().serializeToString(document);
        HTMLCS.process(standard, source, function () {
            if (standard === 'Section508') {
                updateResults508();
            } else {
                updateResults();
            }
        });
    }, 800);
}, 800);

function updateResults() {
    var principles = {
        'Principle1': 'Perceivable',
        'Principle2': 'Operable',
        'Principle3': 'Understandable',
        'Principle4': 'Robust'
    };

    var msgs = HTMLCS.getMessages();
    if (msgs.length === 0) {
        resultsWrapper.innerHTML = '<span class="no-violations">No violations found</span>';
        return;
    }

    var content = '<table id="test-results-table"><tr>';
    content += '<th>#</th><th>Message</th><th>Principle</th><th><acronym title="Success Criterion">SC</acronym></th><th>Techniques</th></tr>';

    var errors = 0;
    var warnings = 0;
    var notices = 0;

    for (var i = 0; i < msgs.length; i++) {
        var msg = msgs[i];
        var type = '';
        switch (msg.type) {
            case HTMLCS.ERROR:
                type = 'Error';
                errors++;
                break;

            case HTMLCS.WARNING:
                type = 'Warning';
                warnings++;
                break;

            case HTMLCS.NOTICE:
                type = 'Notice';
                notices++;
                break;

            default:
                type = 'Unknown';
                break;
        }

        var msgParts = msg.code.split('.');
        var principle = msgParts[1];
        var sc = msgParts[3].split('_').slice(0, 3).join('_');
        var techniques = msgParts[4];
        techniques = techniques.split(',');

        msgParts.shift();
        msgParts.unshift('[Standard]');
        var noStdMsgParts = msgParts.join('.');

        content += '<tr class="' + type.toLowerCase() + '">';
        content += '<td class="number"><span class="flag"></span></td>';
        content += '<td class="messageText"><strong>' + type + ':</strong> ' + msg.msg + '</td>';
        content += '<td class="messagePrinciple">';
        content += '<a href="http://www.w3.org/TR/WCAG20/#' + principles[principle].toLowerCase() + '">' + principles[principle] + '</a>';
        content += '</td>';
        content += '<td class="messageSC">';
        content += '<a href="Standards/WCAG2/' + sc + '">' + sc.replace(new RegExp('_', 'g'), '.') + '</a>';
        content += '</td>';
        content += '<td class="messageTechniques"><ul>';
        for (var j = 0; j < techniques.length; j++) {
            content += '<li><a href="http://www.w3.org/TR/WCAG20-TECHS/' + techniques[j] + '">' + techniques[j] + '</a></li>';
        }
        content += '</ul></td>';
        content += '</tr>';
    }


    var heading = '<h3>Test results</h3>';

    var noticeActive = '';
    var testResultsClass = 'hide-notice';
    if ((errors === 0) && (warnings === 0)) {
        noticeActive = ' class="active"';
        testResultsClass = '';
    }

    heading += '<ul id="results-overview">';
    heading += '<li class="active"><a href="#" onclick="return toggleMsgTypes.call(this, \'error\');"><span class="result-count result-count-errors">' + errors + '</span> <span class="result-type">errors</span></a></li>';
    heading += '<li class="active"><a href="#" onclick="return toggleMsgTypes.call(this, \'warning\');"><span class="result-count result-count-warnings">' + warnings + '</span> <span class="result-type">warnings</span></a></li>';
    heading += '<li' + noticeActive + '><a href="#" onclick="return toggleMsgTypes.call(this, \'notice\');"><span class="result-count result-count-notices">' + notices + '</span> <span class="result-type">notices</span></a></li>';
    heading += '</ul>';
    heading += '<div id="test-results" class="' + testResultsClass + '">';

    content = heading + content;
    content += '</table>';
    content += '<div id="test-results-noMessages"><em>No messages matched the types you selected</em></div>';
    content += '<span class="footnote"><em>Add the Accessibility Auditor bookmarklet to your browser to run this test on any web page.</em></span></div>';
    resultsWrapper.innerHTML = content;

    reorderResults();
}

function reorderResults() {
    var testResultsDiv = document.getElementById('test-results');
    var numberCells = testResultsDiv.querySelectorAll('tr td.number');
    var currRow = 0;

    for (var i = 0; i < numberCells.length; i++) {
        if (window.getComputedStyle) {
            var display = window.getComputedStyle(numberCells[i].parentNode).display;
        } else {
            var display = numberCells[i].parentNode.currentStyle.display;
        }

        if (display !== 'none') {
            currRow++;
            numberCells[i].innerHTML = currRow;
        } else {
            numberCells[i].innerHTML = '';
        }
    }

    if (currRow === 0) {
        document.getElementById('test-results-noMessages').style.display = 'block';
    } else {
        document.getElementById('test-results-noMessages').style.display = 'none';
    }
}