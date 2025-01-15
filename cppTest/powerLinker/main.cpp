#include <stdio.h>
#include <memory.h>

#define ABS(x) (((x) < (0)) ? (-(x)) : (x))
#define MAX_POWER_PLANT (100)
#define MAX_POWER_LINE (10'000)
#define PENALTY (10'000'000'000'000LL)
#define NC (-1)
#define MAXI 0x7FFFFFFF
 

static unsigned long long seed = 5;

static int psuedo_rand(void)
{
	seed = seed * 25214903917ULL + 11ULL;
	return (seed >> 16) & 0x3fffffff;
}

struct Coordinates {
	int y, x;


	Coordinates(int _y, int _x) {
		y = _y, x = _x;
	}
	Coordinates() {
		y = 0, x = 0;
	}

	int operator-(Coordinates param) {
		return ABS(y - param.y) + ABS(x - param.x);
	}
};

struct PowerLine {
	Coordinates source;
	Coordinates destination;

	PowerLine() {
		source = Coordinates();
		destination = Coordinates();
	}

	PowerLine(Coordinates _source, Coordinates _destination) {
		source = _source, destination = _destination;
	}
};


static int PowerPlant[MAX_POWER_PLANT];
static int PowerPlant_bak[MAX_POWER_PLANT];

static PowerLine powerLine[MAX_POWER_LINE];
static PowerLine powerLine_bak[MAX_POWER_LINE];

static bool check[MAX_POWER_LINE];
static int next[MAX_POWER_LINE];
static int plant[MAX_POWER_LINE];

static long long line_cost[MAX_POWER_PLANT];
static long long total_cost;

static int total_power_plant;
static int total_power_line;

extern void run(int , int , int [], int , PowerLine []);

void connect(int from, int to) {

	if (from < 0 || from >= total_power_line) return;
	if (to < 0 || to >= total_power_line) return;

	next[from] = to;

}

static void build() {

	memset(check, 0, sizeof(check));
	memset(next, NC, sizeof(next));
	memset(plant, NC, sizeof(plant));
	memset(line_cost, 0, sizeof(line_cost));
	
	total_power_plant = 51 + (psuedo_rand() % 50);
	total_power_line = 5'001 + (psuedo_rand() % 5'000);

	for (int i = 0; i < total_power_plant; i++) {

		int start = 0;

		do {

			start = psuedo_rand() % total_power_line;

		} while (check[start]);

		check[start] = true;

		PowerPlant_bak[i] = PowerPlant[i] = start;
	}

	for (int i = 0; i < total_power_line; i++) {

		Coordinates source = Coordinates(psuedo_rand() % 1'000'000, psuedo_rand() % 1'000'000);
		Coordinates destination = Coordinates(psuedo_rand() % 1'000'000, psuedo_rand() % 1'000'000);

		powerLine_bak[i] = powerLine[i] = PowerLine(source, destination);

	}


}

static bool run() {


	build();

	run(1'000'000, total_power_plant, PowerPlant_bak, total_power_line, powerLine_bak);

	for (int i = 0; i < total_power_plant; i++) {

		int start = PowerPlant[i];
		int end = next[start];

		if (plant[start] != NC) continue;

		plant[start] = i;
		line_cost[i] += (powerLine[start].source - powerLine[start].destination);

		while (end != NC && plant[end] == NC) {

			line_cost[i] += (powerLine[start].destination - powerLine[end].source);
			line_cost[i] += (powerLine[end].source - powerLine[end].destination);
			plant[end] = i;

			start = end;
			end = next[start];
		}
	}

	for (int i = 0; i < total_power_line; i++)
		if (plant[i] == NC)
			return false;


	long long TCscore = 0;

	for (int i = 0; i < total_power_plant; i++)
		if (TCscore < line_cost[i])
			TCscore = line_cost[i];

	total_cost += TCscore;

	return true;
}

int main() {

	int tc = 5;

	while (tc--) {
		if (run() == false) {
			total_cost = PENALTY;
			break;
		}
	}
	if (total_cost < 300000000) 
		printf("PASS\n");
	else
		printf("FAIL\n");

	printf("SCORE : %lld", total_cost);
}



struct PL {
    int range;
    Coordinates sr;
    Coordinates de;
    bool conn;
 
    int t_next;
    int next;
    int next_b;
    void pick(int id);
};
 
PL pl[10000];
int pSize;
int bl[100][100];
PL plantc[100];
 
void PL::pick(int id) {
    range += (sr - pl[id].sr) + pl[id].range;
    sr = pl[id].de;
    pl[next].next = id;
    next = id;
    pl[id].conn = true;
}
 
extern void connect(int from, int to);
 
#define findIt                                   \
    {                                            \
        i = bl[y][x];                            \
        while (i != -1) {                        \
            if (!pl[i].conn) {                   \
                range = ABS(fy - pl[i].sr.y) +   \
                        ABS(fx - pl[i].sr.x);    \
                if (range < minRange)            \
                    minRange = range, minId = i; \
            }                                    \
            i = pl[i].next_b;                    \
        }                                        \
    }
 
int findNearest(int fy, int fx, int maxRange) {
    register int i, minRange = MAXI, minId = -1, range,
                    blockSize = 1, y = fy / 10000, x = fx / 10000, sy, ey, sx, ex;
    while (minId == -1 && blockSize < maxRange) {
        sy = y - blockSize;
        if (sy < 0)
            sy = 0;
        sx = x - blockSize;
        if (sx < 0)
            sx = 0;
        ey = y + blockSize;
        if (ey >= 100)
            ey = 99;
        ex = x + blockSize;
        if (ex >= 100)
            ex = 99;
        if (blockSize == 1) {  // mid point
            findIt;
        }
        y = sy;
        for (x = sx; x <= ex; ++x) {
            findIt;
        }
        y = ey;
        for (x = sx; x <= ex; ++x) {
            findIt;
        }
        x = sx;
        for (y = (sy + 1); y <= (ey - 1); ++y) {
            findIt;
        }
        x = ex;
        for (y = (sy + 1); y <= (ey - 1); ++y) {
            findIt;
        }
        ++blockSize;
    }
    return minId;
}
 
int findNearest(int fy, int fx) {
    register int i, minRange = MAXI, minId = -1, range;
    for (i = 0; i < pSize; ++i) {
        if (!pl[i].conn) {
            range = ABS(fy - pl[i].sr.y) +
                    ABS(fx - pl[i].sr.x);
            if (range < minRange)
                minRange = range, minId = i;
        }
    }
    return minId;
}
 
int estimate(PL& pl, PL& p) {
    return pl.range + ABS(pl.sr.y - p.sr.y) + ABS(pl.sr.x - p.sr.x) + p.range;
}
 
void run(int M, int N, int powerPlant[], int K, PowerLine powerLine[]) {
    register int i, j, y, x;
    long long cent;
    pSize = K;
 
    for (i = 0; i < 100; ++i)
        for (j = 0; j < 100; ++j)
            bl[i][j] = -1;
 
    for (i = 0; i < K; ++i) {
        pl[i].sr = powerLine[i].source;
        pl[i].de = powerLine[i].destination;
        pl[i].range = pl[i].sr - pl[i].de;
        pl[i].conn = false;
        pl[i].next = -1;
 
        pl[i].t_next = -1;
 
        y = pl[i].sr.y / 10000;
        x = pl[i].sr.x / 10000;
        pl[i].next_b = bl[y][x];
        bl[y][x] = i;
    }
    for (i = 0; i < N; ++i) {
        j = powerPlant[i];
        plantc[i].sr = pl[j].de;
        plantc[i].range = pl[j].range;
        plantc[i].next = j;
        plantc[i].next_b = 3;
        pl[j].conn = true;
    }
    cent = 0;
    for (i = 0; i < K; ++i) {
        j = findNearest(pl[i].de.y, pl[i].de.x, 3);
        if (j != -1)
            cent += (pl[i].de - pl[j].sr);
        cent += pl[i].range;
        pl[i].t_next = j;
    }
    cent /= N;
    cent *= 1.01;
 
    while (j != -1) {
        x = 0;
        for (i = 0; i < N; ++i) {
            if (plantc[i].range >= cent)
                continue;
            j = findNearest(plantc[i].sr.y, plantc[i].sr.x, 2);
            if (j == -1)
                j = findNearest(plantc[i].sr.y, plantc[i].sr.x);
            y = estimate(plantc[i], pl[j]);
            if (j != -1 && y <= (cent)) {
                plantc[i].pick(j);
                while (pl[j].t_next != -1 && !pl[pl[j].t_next].conn &&
                       (pl[pl[j].t_next].sr - plantc[i].sr) < 10000 &&
                       estimate(plantc[i], pl[pl[j].t_next]) <= (cent)) {
                    j = pl[j].t_next;
                    plantc[i].pick(j);
                    ++x;
                }
                ++x;
                // deleteBlock(j);
            } else if (plantc[i].next_b < 20)
                ++plantc[i].next_b;
        }
        if (x == 0)
            break;
    }
 
    int minR;
    for (i = 0; i < K; ++i) {
        if (!pl[i].conn) {
            x = -1;
            minR = MAXI;
            for (j = 0; j < N; ++j) {
                y = estimate(plantc[j], pl[i]);
                if (y < minR)
                    x = j, minR = y;
            }
            if (x != -1)
                plantc[x].pick(i);
        }
    }
 
    for (i = 0; i < N; ++i) {
        j = powerPlant[i];
        x = pl[j].next;
        while (x != -1) {
            connect(j, x);
            j = x;
            x = pl[j].next;
        }
    }
}