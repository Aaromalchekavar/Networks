set ns [new Simulator]
$ns rtproto DV
set nf [open dv.tr w]
$ns trace-all $nf
set nr [open dv.nam w]
$ns namtrace-all $nr

//null is similar to tcpsink
//cbr is similar to ftp